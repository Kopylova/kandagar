var RLS = {
    activeAction: 'index',
    activeParam: '',
	siteUrl: '',
    Validate: {
        email: function(value) {
            var r = new RegExp('^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$');
            return r.test(value);
        },
        date: function(value) {
            var r = new RegExp('^(0[1-9]|(1|2)[0-9]|3[0-1]){1}.(0[1-9]{1}|1[0-2]{1}){1}.(19[0-9]{2}|2[0-9]{3})$');
            return r.test(value);
        },
        password: function(value) {
            var r = new RegExp("^(?=.{6,})(?=.*[A-ZА-Я])(?=.*[a-zа-я])(?=.*[0-9])(?=.*\\W).*$", "g");
            return r.test(value);
        }
        },
    Utils: {
        init: function(activeAction, activeParam, siteUrl) {
            RLS.activeAction = activeAction;
            RLS.activeParam = activeParam;
			RLS.siteUrl = siteUrl;
            $(function() {
                $('.icon-edit').tooltip({
                    placement: 'top'
                });
                $('.icon-remove').tooltip({
                    placement: 'top'
                });
                $('.country-img').tooltip({
                    placement: 'bottom'
                });
                $('.icon-chevron-up').tooltip({
                    placement: 'left',
                    title: function() {
                        return ($(this).hasClass('icon-chevron-up') ? RLS.Constants.collapse[RLS.Private.getCurrentLocale()] : RLS.Constants.expand[RLS.Private.getCurrentLocale()]);
                    }
                });
                $('.icon-chevron-down').tooltip({
                    placement: 'left',
                    title: function() {
                        return ($(this).hasClass('icon-chevron-down') ? RLS.Constants.expand[RLS.Private.getCurrentLocale()] : RLS.Constants.collapse[RLS.Private.getCurrentLocale()]);
                    }
                });
            });
        },
        
        processError: function(message) {
            var oldFocus = jQuery().modal.Constructor.prototype.enforceFocus;
            jQuery().modal.Constructor.prototype.enforceFocus = function(){};

            $('#dlg-error .message-offset').html(message);
            $('#dlg-error').modal('show');

            jQuery().modal.Constructor.prototype.enforceFocus = oldFocus;
        },

        processConfirm: function(message, url, target) {
            $('#act_confirm_ok').off('click').on('click', function() {
                $('#dlg-confirm').modal('hide');
                if (typeof url == 'function') {
                    url.call();
                } else {
                    target = (typeof target !== 'undefined' ? target : '');
                    if (target != '') {
                        window.open(url, target);
                    } else {
                        location.href = url;
                    }
                }
                return false;
            });

            $('#dlg-confirm .message-offset').html(message);
            $('#dlg-confirm').modal('show');
        },

        processMessage: function(message, url, target) {
            $('#act_message_ok').off('click').on('click', function() {
                $('#dlg-message').modal('hide');
                if (typeof url == 'function') {
                    url.call();
                }
				else {
                    target = (typeof target !== 'undefined' ? target : '');
                    if (target != '') {
                        window.open(url, target);
                    } else {
						if(url !== undefined) {
							location.href = url;
						}                        
                    }
                }
                return false;
            });

            $('#dlg-message .message-offset').html(message);
            $('#dlg-message').modal('show');
        },
		
		areYouSure: function(url, confirmMessage) {
            confirmMessage = (typeof confirmMessage !== 'undefined' ? confirmMessage : RLS.Constants.confirmMessage);
            RLS.Utils.processConfirm(confirmMessage, url);
            return false;
        },
		
		showMessage: function(message) {             
            RLS.Utils.processMessage(message);
            return false;
        },

        registerFilterExpandCollapse: function(ctrlId, isIgnorePath) {
            isIgnorePath = (typeof isIgnorePath !== 'undefined' ? isIgnorePath : false);
            $(function() {
                var filter = $.cookie(RLS.activeAction + (RLS.activeParam ? '_' + RLS.activeParam : '') + '_filter');
                if (filter) {
                    $("#filter_body").toggleClass(filter === "1" ? 'in' : '');
                    $("#" + ctrlId).find("i").attr("class", filter === "1" ? 'icon-chevron-up' : 'icon-chevron-down');
                }
                $('#' + ctrlId).on('click', function() {
                    var caption = $(this).find('i');
                    caption.toggleClass('icon-chevron-down icon-chevron-up');
                    $.cookie((isIgnorePath ? ctrlId : RLS.activeAction + (RLS.activeParam ? '_' + RLS.activeParam : '') + '_filter'), (caption.hasClass('icon-chevron-up') ? 1 : 0), { expires: 365 });
                });
            });
        },

        registerTextareaLimit: function() {
            $(function() {
                $('.limited').each(function() {
                    var ctrl = $(this);
                    if (ctrl.is('textarea')) {
                        var ctrlCountId = 'limit_' + $(this).attr('name');
						var message = RLS.Constants.howCharacters[RLS.Private.getCurrentLocale()];
                        ctrl.parent().append('<br />' + message + ' <span id="' + ctrlCountId + '"></span>');
                        ctrl.on('keyup', function() {
                            $('#' + ctrlCountId).html(function() {
                                var limit = ctrl.attr('class').match(/limit_[\d]+/);
                                var total = limit[0].split('_')[1];
                                var left = total - ctrl.val().length;
                                if (left < 0) {
                                    ctrl.val(ctrl.val().substr(0, total));
                                    left = 0;
                                }
                                return left;
                            });
                        });
                        ctrl.trigger('keyup');
                    }
                });
            });
        },

        registerDatepicker: function(ctrlId, endDate) {
            $(function() {
                $('#' + ctrlId).datepicker({
                    autoclose: true,
                    format: 'dd.mm.yyyy',
                    endDate: endDate,
					language: RLS.Private.getCurrentLocale()
                });
				$('#' + ctrlId).mask('99.99.9999');
                $('#' + ctrlId).next('span.add-on').on('click', function() {
                    $('#' + ctrlId).datepicker('show');
                });
            });
        },

        registerFormValidation: function(ctrlId, container) {
            container = (typeof container !== 'undefined' ? container : 'form');

            $(container + ' .control-group.required').each(function(){
            	RLS.Private.addRequiredValidation($(this));
            });

            $(container + ' .control-group.email').each(function(){
            	RLS.Private.addEmailValidation($(this));
            });

            $(container + ' .control-group.password').each(function(){
            	RLS.Private.addPasswordValidation($(this));
            });

            $(container + ' .control-group.date').each(function(){
            	RLS.Private.addDateValidation($(this));
            });

            $(container + ' .control-group.complex').each(function(){
            	RLS.Private.addComplexValidation($(this));
            });

            $(function() {
                $('#' + ctrlId).off('click').on('click', function() {	
					$.each($(container).find('.nav-tabs a'), function(i, tab_link) {
						$(tab_link).css('color', '#0088cc'); 
					});

                    var errorGroup = null;
                    $(container + ' .control-group.required, ' +
                        container + ' .control-group.email, ' +
                        container + ' .control-group.password, ' +
                        container + ' .control-group.date,' +
                        container + ' .control-group.complex').each(function() {
                        	RLS.Utils.validate($(this).data('control'));
                            if ($(this).hasClass('error') && errorGroup == null) {
                                errorGroup = $(this);
                            }
                        })
                    if (errorGroup) {
                        var tabId = errorGroup.parents('.tab-pane').attr('id');
                        if (tabId) {
							var tab = $('ul.nav-tabs li a[href=#' + tabId + ']');
                            tab.tab('show');
							tab.css('color', 'red');
                        }
                    }
                    return ($(container + ' .control-group.error').length == 0);
                });
            });
        },

        clearError: function(ctrlId) {
            var group = $('.control-group[data-control=' + ctrlId + ']');
            RLS.Private.clearError(group);
        },

        validate: function(control) {
			if(control.charAt(0) != '.') {
				control = '#' + control;
			}
			
			$(control).trigger('change.validation');
        },

        processError: function(message) {
            var oldFocus = jQuery().modal.Constructor.prototype.enforceFocus;
            jQuery().modal.Constructor.prototype.enforceFocus = function(){};

            $('#dlg-error .message-offset').html(message);
            $('#dlg-error').modal('show');

            jQuery().modal.Constructor.prototype.enforceFocus = oldFocus;
        },

        processConfirm: function(message, url, target) {
            $('#act_confirm_ok').off('click').on('click', function() {
                $('#dlg-confirm').modal('hide');
                if (typeof url == 'function') {
                    url.call();
                } else {
                    target = (typeof target !== 'undefined' ? target : '');
                    if (target != '') {
                        window.open(url, target);
                    } else {
                        location.href = url;
                    }
                }
                return false;
            });

            $('#dlg-confirm .message-offset').html(message);
            $('#dlg-confirm').modal('show');
        },

        areYouSure: function(url, confirmMessage) {
            confirmMessage = (typeof confirmMessage !== 'undefined' ? confirmMessage : RLS.Constants.confirmMessage[RLS.Private.getCurrentLocale()]);
            RLS.Utils.processConfirm(confirmMessage, url);
            return false;
        },

        formatNumber: function(value, decimals) {
            decimals = (typeof decimals !== 'undefined' ? decimals : 2);
            return RLS.Utils.addCommas((isNaN(value) ? 0 : value).toFixed(decimals));
        },

        toFixed: function(value, decimals) {
            decimals = (typeof decimals !== 'undefined' ? decimals : 2);
            return (isNaN(value) ? 0 : value).toFixed(decimals);
        },
    },
    Private: {
        clearError: function(group) {
            group.removeClass('error');
            group.find('div img.error').remove();
        },
        addError: function(group, message) {
            var errorIcon = RLS.Private.renderTemplate(RLS.Constants.errorIcon, {
                title: message,
				site_url: RLS.siteUrl
            });			
            var iconContainer = group.data('icon-container');			
			group.addClass('error');
            if (iconContainer !== undefined) {				
                $('#' + iconContainer).append(errorIcon);
            } else {                
                if (group.find('div.controls textarea').length > 0) {
                    group.find('div.controls textarea').after(errorIcon);
                } else if (group.find('div.controls .input-append').length > 0) {
                    group.find('div.controls .input-append').append(errorIcon);
                } else {
                    group.find('div.controls').append(errorIcon);
                }
            }
            group.find('div img.error').tooltip({
                placement: 'right',
                html: true
            });
        },
        renderTemplate: function(template, options) {
            return $('<div />').append($.tmpl(template, options)).html();
        },
        space: function(value) {
            return value.replace(/\s/gm, '&nbsp;');
        },
        clearRequiredValidation: function(group) {
            $('#' + group.data('control')).off('change.validation.required');
        },
        addRequiredValidation: function(group) {
            $('#' + group.data('control')).on('change.validation.required', function(e) {
                if (e.result) return e.result;
                RLS.Private.clearError(group);
                var condition = group.data('required-condition');
                if (($.trim($(this).val()) == '') && (condition ? eval(condition) : true)) {
                    var message = group.data('required-message');
                    if (!message) {
                        message = RLS.Private.renderTemplate(RLS.Private.space(RLS.Constants.requiredMessage[RLS.Private.getCurrentLocale()]), {
                            field_name: group.find('label').text().trim()
                        });
                    }
                    RLS.Private.addError(group, message);
                    e.result = true;
                }
            });
        },
        addEmailValidation: function(group) {
            $('#' + group.data('control')).on('change.validation.email', function(e) {
                if (e.result) return e.result;
                RLS.Private.clearError(group);
                if ($.trim($(this).val()) != '') {
                    if (!RLS.Validate.email($(this).val())) {
                        var message = group.data('email-message');
                        if (!message) {
                            message = RLS.Private.renderTemplate(RLS.Private.space(RLS.Constants.formatMessage[RLS.Private.getCurrentLocale()]), {
                                field_name: group.find('label').text().trim()
                            });
                        }
                        RLS.Private.addError(group, message);
                        e.result = true;
                    }
                }
            });
        },
        addPasswordValidation: function(group) {
            $('#' + group.data('control')).on('change.validation.password', function(e) {
                if (e.result) return e.result;
                RLS.Private.clearError(group);
                if ($.trim($(this).val()) != '') {
                    if (!RLS.Validate.password($(this).val())) {
                        var message = group.data('password-message');
                        if (!message) {
                            message = RLS.Private.renderTemplate(RLS.Private.space(RLS.Constants.passwordSecurityMessage[RLS.Private.getCurrentLocale()]), {
                                field_name: group.find('label').text().trim()
                            });
                        }
                        RLS.Private.addError(group, message);
                        e.result = true;
                    }
                }
            });
        },
        addDateValidation: function(group) {
            $('#' + group.data('control')).on('change.validation.date', function(e) {
                if (e.result) return e.result;
                RLS.Private.clearError(group);
                if ($.trim($(this).val()) != '') {
                    if (!RLS.Validate.date($(this).val())) {
                        var message = group.data('date-message');
                        if (!message) {
                            message = RLS.Private.renderTemplate(RLS.Private.space(RLS.Constants.formatMessage[RLS.Private.getCurrentLocale()]), {
                                field_name: group.find('label').text().trim()
                            });
                        }
                        RLS.Private.addError(group, message);
                        e.result = true;
                    }
                }
            });
        },
        addComplexValidation: function(group) {
        var control = group.data('control');
        if(control.charAt(0) != '.' && control.charAt(0) != '#') {
            control = '#' + control;
        }
        $(control).live('change.validation.complex', function(e) {
            if (e.result) return e.result;
            RLS.Private.clearError(group);
            var condition = group.data('condition');
            if (typeof eval(condition) == 'function') {
                    if(!eval(condition).call()) {
                        var message = group.data('complex-message');
                        RLS.Private.addError(group, message);
                        e.result = true;
                    }
                }
            });
        },
        getCurrentLocale: function() {
        	return $.cookie('locale')=='en' ? 'en' : 'ru';
        }
    },
    Constants: {
        collapse: { 'ru': 'Свернуть', 
    	      'en': 'Turn' },
        expand: { 'ru': 'Развернуть', 
  	      'en': 'Expand' }, 
		howCharacters: { 'ru': 'Осталось символов:', 
  	      'Remaining characters:': 'Expand' }, 
        errorIcon: '<img class="error" src="${site_url}/images/error-icon.png" style="padding-left:5px;" rel="tooltip" title="${title}" />',
        confirmMessage:  { 'ru': 'Вы уверены, что хотите удалить этот элемент?', 
    	      'en': 'Are you sure you want to delete this item' }, 
    	loadResumeMessage:  { 'ru': '�� �������, ��� ������ ������ �������� ������?', 
        	      'en': 'Are you sure you want to load resume?' }, 
        requiredMessage: { 'ru': 'Поле <strong>${field_name}</strong> обязательное для заполнения.','en': '<strong>${field_name}</strong> - required field.' },     	
        formatMessage: { 'ru': 'Значение поля <strong>${field_name}</strong> имеет некорректный формат.', 
    	      'en': 'The value of the field <strong>${field_name}</strong> is malformed.' }, 
        passwordSecurityMessage: { 'ru': 'Пароль должен быть не менее 6 символов <br> и содержать цифры, буквы в верхнем и <br> нижнем регистре, а также спецсимволы.', 
  	      'en': 'The password must be at least 6 characters <br> and contain numbers, letters, uppercase and lowercase <br>, and special characters.' },  
        rangeFromMessage: { 'ru': 'Значение поля <strong>${field_name}</strong> должно быть больше или равно ${value_min}.', 
  	      'en': 'The value of the field <strong>${field_name}</strong> must be greater than or equal to ${value_min}.' },
        rangeToMessage: { 'ru': 'Значение поля <strong>${field_name}</strong> должно быть меньше или равно ${value_max}.', 
    	      'en': 'The value of the field <strong>${field_name}</strong> must be less than or equal ${value_max}.' },
        rangeBetweenMessage: { 'ru': 'Значение поля <strong>${field_name}</strong> должно быть между ${value_min} и ${value_max}.', 
  	      'en': 'The value of the field <strong>${field_name}</strong> should be between ${value_min} and ${value_max}.' }
    }
}