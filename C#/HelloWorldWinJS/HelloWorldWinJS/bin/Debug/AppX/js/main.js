// Para uma introdução ao modelo em Branco, consulte a seguinte documentação:
// https://go.microsoft.com/fwlink/?LinkId=232509

(function () {
	"use strict";

	var app = WinJS.Application;
	var activation = Windows.ApplicationModel.Activation;
	var isFirstActivation = true;

	app.onactivated = function (args) {
		if (args.detail.kind === activation.ActivationKind.voiceCommand) {
			// TODO: Manuseie ActivationKinds relevantes. Por exemplo, se seu aplicativo puder ser iniciado por comandos de voz,
			// este será um bom momento para decidir se deseja preencher um campo de entrada ou escolher uma exibição diferente.
		}
		else if (args.detail.kind === activation.ActivationKind.launch) {
			// Uma ativação de inicialização ocorre quando o usuário inicia o aplicativo por meio do bloco
			// ou invoca uma notificação do sistema ao clicar ou tocar no corpo.
			if (args.detail.arguments) {
				// TODO: Se o aplicativo der suporte a notificações do sistema, use esse valor de carga de notificação do sistema para determinar o lugar no aplicativo
				// para levar o usuário em resposta a eles, invocando uma notificação do sistema.
			}
			else if (args.detail.previousExecutionState === activation.ApplicationExecutionState.terminated) {
				// TODO: Esse aplicativo foi suspenso e, em seguida, encerrado para recuperar memória.
				// Para oferecer uma experiência do usuário uniforme, restaure o estado do aplicativo aqui para que pareça que ele nunca parou de funcionar.
				// Observação: Talvez você queira registrar horário em que o aplicativo foi suspenso pela última vez e só restaurar o estado se ele tiver retornado após um curto período.
			}
		}

		if (!args.detail.prelaunchActivated) {
			// TODO: Caso prelaunchActivated seja verdadeiro, isso significa que o aplicativo foi pré-inicializado em segundo plano como uma otimização.
			// Nesse caso, ele poderia ser suspenso logo depois.
			// Qualquer operação de longa duração (como rede cara ou E/S de disco) ou alterações no estado do usuário que ocorrem na inicialização
			// deve ser feita aqui (para evitar fazê-la no caso de pré-inicialização).
			// Como alternativa, esse trabalho pode ser feito em um manipulador de retomada ou visibilitychanged.
		}

		if (isFirstActivation) {
			// TODO: O aplicativo foi ativado e não estava em execução. Faça a inicialização geral aqui.
			document.addEventListener("visibilitychange", onVisibilityChanged);
            args.setPromise(WinJS.UI.processAll());

            args.setPromise(WinJS.UI.processAll().then(function completed() {
                var ratingControlDiv = document.getElementById("ratingControlDiv");
                var ratingControl = ratingControlDiv.winControl;
                ratingControl.addEventListener("change", ratingChanged, false);
            }));

            var helloButtom = document.getElementById("helloButtom");
            helloButtom.addEventListener("click", buttomClickHandler, false);
		}

		isFirstActivation = false;
	};

	function onVisibilityChanged(args) {
		if (!document.hidden) {
			// TODO: O aplicativo acabou de se tornar visível. Isso pode ser um bom momento para atualizar a exibição.
		}
	}

	app.oncheckpoint = function (args) {
		// TODO: este aplicativo está prestes a ser suspenso. Salve aqui qualquer estado que precise ser mantido entre as suspensões.
		// Você pode usar o objeto WinJS.Application.sessionState, que é automaticamente salvo e restaurado na suspensão.
		// Se for necessário concluir uma operação assíncrona antes da suspensão do aplicativo, chame args.setPromise().
    };

    function buttomClickHandler(eventInfo) {
        var userName = document.getElementById("nameInput").value;
        var greetingString = "Olá, " + userName + "!";
        document.getElementById("greetingOutput").innerText = greetingString;
    }

    function ratingChanged(eventInfo) {
        var ratingOutput = document.getElementById("ratingOutput");
        ratingOutput.innerText = eventInfo.detail.tentativeRating;
    }

	app.start();

})();
