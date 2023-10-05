import java.io.File


fun main(){
    val nome = "CapturaDadosPy.py"

    var arq = File(nome)


    arq.writeText("import math\n" +
            "import psutil\n" +
            "import time\n" +
            "import platform\n" +
            "import mysql.connector\n" +
            "import ping3\n" +
            "import socket\n" +
            "\n" +
            "\n" +
            "def converter_segundos_para_horas_minutos_segundos(segundos):\n" +
            "    horas = segundos // 3600  # 1 hora = 3600 segundos\n" +
            "    segundos_restantes = segundos % 3600\n" +
            "    minutos = segundos_restantes // 60\n" +
            "    segundos_final = math.ceil(segundos_restantes % 60)\n" +
            "\n" +
            "    return horas, minutos, segundos_final\n" +
            "\n" +
            "def bytes_para_gb(bytes_value):\n" +
            "    return bytes_value / (1024 ** 3)\n" +
            "\n" +
            "#mydb = mysql.connector.connect(host = 'localhost',user = 'root',passwd = '5505',database = 'SecureATM')\n" +
            "#cursor = mydb.cursor()\n" +
            "#id_atm = 1\n" +
            "#id_empresa = 1\n" +
            "\n" +
            "print(\"\\n-----------------------------------------\")\n" +
            "componente = input(\"Qual plano você deseja analisar? \\nStandard: CPU, Memória, Disco \\nProfessional: CPU, Memória, Disco e Rede\\nUltra: CPU, Memória, Disco, Rede, Janela de Sistemas e Sensor\\n-----------------------------------------\\n\")\n" +
            "\n" +
            "print(\"\\n-----------------------------------------\")\n" +
            "print(\"\\nComponente = CPU\\n\")\n" +
            "print(\"-----------------------------------------\")\n" +
            "\n" +
            "while(True):\n" +
            "        \n" +
            "    print(\"\\nSituação geral: \")\n" +
            "    print(\"-----------------------------------------\")\n" +
            "        \n" +
            "    ps = psutil.cpu_times()\n" +
            "        \n" +
            "    TempoUsuarioHoras, TempoUsuarioMinutos, TempoUsuarioSegundos = converter_segundos_para_horas_minutos_segundos(ps[0])\n" +
            "    TempoSistemaHoras, TempoSistemaMinutos, TempoSistemaSegundos = converter_segundos_para_horas_minutos_segundos(ps[1])\n" +
            "    tempo_usuario = \"{:.2f}\".format(ps[0])\n" +
            "    tempo_sistema = ps[1] \n" +
            "    porcentagem_utilizacao = psutil.cpu_percent(percpu = False)\n" +
            "    numeroCpu = psutil.cpu_count()  \n" +
            "    frequenciaCpuMhz = psutil.cpu_freq(percpu=False)\n" +
            "    velocidade = \"{:.2f}\".format(frequenciaCpuMhz.current / 1000)\n" +
            "    processos = len(psutil.pids())\n" +
            "\n" +
            "    print(\"Número de processos\", processos)\n" +
            "    print(\"Tempo:\")\n" +
            "    print(\"Tempo de usuário:\", TempoUsuarioHoras, \"h\", TempoUsuarioMinutos, 'm e',TempoUsuarioSegundos, 's')  \n" +
            "    print(\"Tempo de sistema:\", TempoSistemaHoras, \"h\", TempoSistemaMinutos, 'm e',TempoSistemaSegundos, 's')      \n" +
            "        \n" +
            "\n" +
            "    print(\"\\nUtilização:\")\n" +
            "    print(\"Porcentagem sendo utilizada da CPU: \", porcentagem_utilizacao, \"%\")\n" +
            "    print()\n" +
            "\n" +
            "    print(\"Outros:\")\n" +
            "    print(\"\\nNúmero de CPUs lógicas no sistema:\", numeroCpu)\n" +
            "    print(\"\\nNúmero de processos:\", processos)\n" +
            "    print(\"\\nFrequencia das CPUs no sistema:\", velocidade, \"GHz\")\n" +
            "    print()\n" +
            "\n" +
            "    print(\"\\n-----------------------------------------\")\n" +
            "    print(\"\\nComponente = Disco\\n\")\n" +
            "    print(\"-----------------------------------------\")\n" +
            "\n" +
            "    print(\"\\nSituação geral: \")\n" +
            "    print(\"-----------------------------------------\")\n" +
            "    particoes = psutil.disk_partitions()\n" +
            "\n" +
            "    print(\"Partições de Disco:\")\n" +
            "    for particao in particoes:\n" +
            "        print(\"Ponto de Montagem:\", particao.mountpoint)\n" +
            "        print(\"Sistema de Arquivos:\", particao.fstype)\n" +
            "        print(\"Dispositivo:\", particao.device)\n" +
            "    print()\n" +
            "            \n" +
            "    meu_so = platform.system()\n" +
            "    if(meu_so == \"Linux\"):\n" +
            "        nome_disco = '/'\n" +
            "        disco = psutil.disk_usage(nome_disco)\n" +
            "    elif(meu_so == \"Windows\"):\n" +
            "        nome_disco = 'C:\\\\'\n" +
            "        disco = psutil.disk_usage(nome_disco) \n" +
            "\n" +
            "    porcentagem_uso = disco.percent\n" +
            "    capacidade_total = \"{:.2f}\".format(bytes_para_gb(disco.total))\n" +
            "    capacidade_usada = \"{:.2f}\".format(bytes_para_gb(disco.used))\n" +
            "    capacidade_livre = \"{:.2f}\".format(bytes_para_gb(disco.free))\n" +
            "\n" +
            "    print(\"Uso de Disco:\")\n" +
            "    print(f\"Nome do Disco:\", nome_disco)\n" +
            "    print(f\"Total:\", capacidade_total, \"bytes\")\n" +
            "    print(f\"Usado:\", capacidade_usada, \"bytes\")\n" +
            "    print(f\"Livre:\", capacidade_livre, \"bytes\")\n" +
            "    print(f\"Percentual de Uso:\", porcentagem_uso, \"%\")\n" +
            "    print()\n" +
            "\n" +
            "    io_disco = psutil.disk_io_counters(perdisk=True)\n" +
            "    print(\"E/S de Disco:\")\n" +
            "    for disco, io in io_disco.items():\n" +
            "        leituras = io.read_count\n" +
            "        escritas = io.write_count\n" +
            "        print(f\"Disco:\", disco)\n" +
            "        print(f\"Leituras:\", io.read_count)\n" +
            "        print(f\"Escritas:\", io.write_count)\n" +
            "        print()\n" +
            "            \n" +
            "\n" +
            "    print(\"\\n-----------------------------------------\")\n" +
            "    print(\"\\nComponente selecionado = Memória\\n\")\n" +
            "    print(\"-----------------------------------------\")\n" +
            "\n" +
            "    memoria_virtual = psutil.virtual_memory()\n" +
            "    total = \"{:.2f}\".format(bytes_para_gb(memoria_virtual.total))\n" +
            "    livre = \"{:.2f}\".format(bytes_para_gb(memoria_virtual.available))\n" +
            "    usado = \"{:.2f}\".format(bytes_para_gb(memoria_virtual.used))\n" +
            "    porcentagem_uso = memoria_virtual.percent\n" +
            "    print(\"Memória Virtual:\")\n" +
            "    print(\"Total:\", total,\"GB\")\n" +
            "    print(\"Disponível:\", livre,\"GB\")\n" +
            "    print(\"Usado:\", usado,\"GB\")\n" +
            "    print(\"Percentual de Uso:\", porcentagem_uso,\"%\")\n" +
            "    print()\n" +
            "\n" +
            "    swap = psutil.swap_memory()\n" +
            "    print(\"Swap:\")\n" +
            "    print(\"Total: {:.2f} GB\".format(bytes_para_gb(swap.total)))\n" +
            "    print(\"Usado: {:.2f} GB\".format(bytes_para_gb(swap.used)))\n" +
            "    print(\"Livre: {:.2f} GB\".format(bytes_para_gb(swap.free)))\n" +
            "    print(\"Percentual de Uso:\", swap.percent,\"%\")\n" +
            "    print()\n" +
            "\n" +
            "    if(componente == \"Professional\"):\n" +
            "        print(\"\\n-----------------------------------------\")\n" +
            "        print(\"\\nComponente = Rede\\n\")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "        print(\"\\nSituação geral: \")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "\n" +
            "        # Coletar informações de rede com psutil\n" +
            "        network_info = psutil.net_if_addrs()\n" +
            "\n" +
            "        # Iterar pelas interfaces de rede\n" +
            "        for interface, addresses in network_info.items():\n" +
            "            for address in addresses:\n" +
            "                if address.family == socket.AF_INET:\n" +
            "                    #endereco_ip = address.address\n" +
            "                    nome_host = address.broadcast or \"\"\n" +
            "                    tipo_conexao = interface\n" +
            "                    velocidade_conexao = psutil.net_if_stats()[interface].speed\n" +
            "                    #uso_banda = psutil.net_io_counters(pernic=True)[interface].bytes_sent / 1024 / 1024  # MB\n" +
            "                    #latencia_ms = ping3.ping(endereco_ip) \n" +
            "                    status = \"Ativo\"  # obs: lógica para verificar o status da conexão aqui\n" +
            "        io_rede = psutil.net_io_counters()\n" +
            "        bytes_enviados = io_rede.bytes_sent\n" +
            "        bytes_recebidos = io_rede.bytes_recv\n" +
            "        print(\"Tráfego de Rede Total:\")\n" +
            "        #print(\"Nome host:\", nome_host)\n" +
            "        #print(\"Endereço IP:\", endereco_ip)\n" +
            "        print(\"Tipo conexão:\", tipo_conexao)\n" +
            "        print(\"Velocidade conexão:\", velocidade_conexao)\n" +
            "        #print(\"Latencia(ms):\", latencia_ms)\n" +
            "        print(\"Bytes Recebidos:\", io_rede.bytes_recv)\n" +
            "        print(\"Bytes Enviados:\", io_rede.bytes_sent)\n" +
            "\n" +
            "        \n" +
            "\n" +
            "    elif(componente == \"Ultra\"):\n" +
            "        print(\"\\n-----------------------------------------\")\n" +
            "        print(\"\\nComponente = Sensor\\n\")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "        print(\"\\nSituação geral: \")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "        \n" +
            "        \n" +
            "        dadosBateria = psutil.sensors_battery()\n" +
            "        TempoRestanteHoras, TempoRestanteMinutos, TempoRestanteSegundos = converter_segundos_para_horas_minutos_segundos(dadosBateria.secsleft)\n" +
            "        bateriaEstado = 'Desligado'\n" +
            "        if dadosBateria.power_plugged == True:\n" +
            "            bateriaEstado = 'Ligado'\n" +
            "        print(\"Bateria:\")\n" +
            "        print(\"Porcentagem:\", dadosBateria.percent, \"%\")\n" +
            "        print(\"Tempo restante:\", TempoRestanteHoras, \"h\", TempoRestanteMinutos, 'm e',TempoRestanteSegundos, 's')  \n" +
            "        print(\"Carregamento:\", bateriaEstado)\n" +
            "        print()\n" +
            "\n" +
            "        # sensor_data = psutil.sensors_temperatures()\n" +
            "\n" +
            "        print(\"\\n-----------------------------------------\")\n" +
            "        print(\"\\nJanela de Sistemas\\n\")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "        print(\"\\nSituação geral: \")\n" +
            "        print(\"-----------------------------------------\")\n" +
            "\n" +
            "        import pygetwindow as gw\n" +
            "\n" +
            "        janela_ativa = gw.getActiveWindow()\n" +
            "\n" +
            "        titulo_da_janela = janela_ativa.title\n" +
            "\n" +
            "        print(f\"Janela Ativa: {titulo_da_janela}\")\n" +
            "    time.sleep(20)")

    val nomerar = "ziip.rar"

    var arqrar = File(nomerar)

    // esceve o conteudo do novo arquvio aqui criado
    arqrar.writeText("Rar!\u001A\u0007\u0001 óá‚ë\u000B\u0001\u0005\u0007 \u0006\u0001\u0001€€€ ·rY\u0081+\u0002\u0003\u000B˜ \u0004˜  ß–¢Ý€  \u000Fziip/amigos.txt\n" +
            "\u0003\u0002Æ\u0006uÉ«÷Ù\u0001eu amo muito meus amigosN\u0001æ])\u0002\u0003\u000Bˆ \u0004ˆ  •u\u000Fí€  \n" +
            "ziip/oioi.txt\n" +
            "\u0003\u0002\u008FRC¸«÷Ù\u0001oioioioiÊ\u0004ž]\u001E\u0002\u0003\u000B \u0005 \u0010    €  \u0004ziip\n" +
            "\u0003\u0002žjtÉ«÷Ù\u0001\u001DwVQ\u0003\u0005\u0004 " )
//cuidado com o ALT ENTEEER

}
