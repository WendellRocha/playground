#!/usr/bin/env ruby

class MegaAnfitriao
	attr_accessor :nomes

	# Criando o objeto
	def initialize(nomes = "Mundo")
		@nomes = nomes
	end

	# Dizer olá a todos
	def diz_ola
		if @nomes.nil?
			puts "..."
		elsif @nomes.respond_to?("each")
			# @nomes é uma lista de algum tipo,
			# assim podemos iterar!
			@nomes.each do |nome|
				puts "Olá #{nome}"
			end
		else
			puts "Olá #{@nomes}"
		end
	end

	# Dizer adeus a todos
	def diz_adeus
		if @nomes.nil?
			puts "..."
		elsif @nomes.respond_to?("join")
			# juntar todos os elementos à lista
			# usando a vírgula como separador
			puts "Adeus #{@nomes.join(", ")}. Voltem sempre."
		else
			puts "Adeus #{@nomes}. Volte sempre."
		end
	end
end

if __FILE__ == $0
	mg = MegaAnfitriao.new
	mg.diz_ola
	mg.diz_adeus

	# Alterar o nome para Diogo
	mg.nomes = "Diogo"
	mg.diz_ola
	mg.diz_adeus

	# Alterar o nome para um vetor de nomes
	mg.nomes = ["Alberto", "Beatriz", "Carlos", "David", "Ernesto"]
	mg.diz_ola
	mg.diz_adeus

	# Alternar para nil
	mg.nomes = nil
	mg.diz_ola
	mg.diz_adeus
end
