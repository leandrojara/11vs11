package br.com.a11vs11.app.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.a11vs11.app.R;
import br.com.a11vs11.app.model.FAQ;
import br.com.a11vs11.app.model.Manager;

/**
 * Created by Leandro Jara on 25/09/2017.
 */

public class DBManager {

    private static final String DB_NAME = "DB11vs11";
    private static final int DB_VERSION = 1;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    public static void updateDB(Context context) {
        try {
            context.deleteDatabase(DB_NAME);
        } catch (Exception e) {

        }

        SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);

        for (int i = 1; i <= DB_VERSION; i++) {
            switch (i) {
                case 1:
                    try {
//                        creating tables
                        db.execSQL("create table faq(" +
                                "id integer primary key autoincrement," +
                                "pergunta text," +
                                "resposta text" +
                                ");");
                        db.execSQL("create table plataforma(" +
                                "id integer primary key autoincrement," +
                                "nome text" +
                                ");");
                        db.execSQL("create table clube(" +
                                "id integer primary key autoincrement," +
                                "nome text," +
                                "plataforma integer," +
                                "drawable integer," +
                                "foreign key(plataforma) references plataforma(id)" +
                                ");");
                        db.execSQL("create table manager(" +
                                "id integer primary key autoincrement," +
                                "nome text," +
                                "telefone text," +
                                "email text," +
                                "clube integer," +
                                "foreign key(clube) references clube(id)" +
                                ");");

//                        inserting data
                        db.execSQL("insert into plataforma (nome) values " +
                                "('XBOX'), ('PS4'), ('PC');");
                        db.execSQL("insert into clube (nome, plataforma, drawable) values ('Akolty FC', 1, " + R.mipmap.logo_akolty_fc + ")," +
                                "('All Blacks Team', 1, 0)," +
                                "('ALL GAZARRA E-SPORTS', 2, " + R.mipmap.logo_all_gazarra_esports + ")," +
                                "('American Boys FC', 1, " + R.mipmap.logo_american_boys_fc + ")," +
                                "('Amigos Da Cevada ', 2, " + R.mipmap.logo_amigos_da_cevada + ")," +
                                "('ARENA FIFA E-SPORTS', 2, 0)," +
                                "('Arsenalcool FC', 1, " + R.mipmap.logo_arsenalcool_fc + ")," +
                                "('Atlético D.N', 2, 0)," +
                                "('Barça FC', 2, 0)," +
                                "('Barzilai', 3, " + R.mipmap.logo_barzilai + ")," +
                                "('BIRDEAUX FC', 3, 0)," +
                                "('Bixcoito de Futebol Virtual', 2, " + R.mipmap.logo_bixcoito + ")," +
                                "('Black Pumas', 1, " + R.mipmap.logo_black_pumas + ")," +
                                "('BOLEIROS E-SPORTS', 2, 0)," +
                                "('Bonde da C', 2, 0)," +
                                "('Bravos FC', 3, 0)," +
                                "('Bravos FC Xone', 1, 0)," +
                                "('brazilian storm', 2, 0)," +
                                "('BRAZILIAN STORM E-SPORTS', 2, 0)," +
                                "('C A Pojeto juniors', 2, " + R.mipmap.logo_projeto_juniors + ")," +
                                "('CANELAS FC', 3, " + R.mipmap.logo_canelas_fc + ")," +
                                "('Cariocas FR', 2, " + R.mipmap.logo_cariocas + ")," +
                                "('Castelo e-Sports', 2, " + R.mipmap.logo_castelo_esports + ")," +
                                "('Caucaia fifeiros', 2, 0)," +
                                "('Champions Fifa Br E-Sports', 2, 0)," +
                                "('Coroas', 3, " + R.mipmap.logo_coroas + ")," +
                                "('Cruzoeiro E-Sports', 2, " + R.mipmap.logo_cruzoeiro + ")," +
                                "('Dangers CR', 2, 0)," +
                                "('Diabos Vermelhos', 2, 0)," +
                                "('Diavolo e-Sports', 1, 0)," +
                                "('Dibrentus', 1, 0)," +
                                "('Ditadores Es', 2, 0)," +
                                "('DKG UNITED ', 2, 0)," +
                                "('Dragões da Real E-Sports', 2, " + R.mipmap.logo_dragoes_da_real + ")," +
                                "('EC Canarinho', 2, 0)," +
                                "('EC GALATICOS', 2, 0)," +
                                "('EC Invictus ', 1, 0)," +
                                "('EC Marseille', 1, " + R.mipmap.logo_marseille + ")," +
                                "('EC Newcastle', 1, 0)," +
                                "('Exilados FC', 1, " + R.mipmap.logo_exilados + ")," +
                                "('FAMÍLIA FC', 3, 0)," +
                                "('FBA E-SPORTS', 2, " + R.mipmap.logo_fba_esports + ")," +
                                "('Fc Gênesis ', 3, 0)," +
                                "('FEA FV', 2, 0)," +
                                "('Fenômenos P.C.L', 2, " + R.mipmap.logo_fenomenos_pcl + ")," +
                                "('FIFA CAMPINA', 2, " + R.mipmap.logo_fifa_campina + ")," +
                                "('Fifanaticos EC', 2, 0)," +
                                "('Fly and Take', 3, " + R.mipmap.logo_fly_and_take + ")," +
                                "('FranGames E-Sports', 2, " + R.mipmap.logo_frangames + ")," +
                                "('Fuleragi FC', 2, 0)," +
                                "('Full House FC', 2, 0)," +
                                "('Furacão E-SPORTS', 2, 0)," +
                                "('Galáticos Football Players', 1, 0)," +
                                "('Game Over F.V', 2, " + R.mipmap.logo_game_over + ")," +
                                "('Giants FC', 3, 0)," +
                                "('GOLD BRASIL', 3, " + R.mipmap.logo_gold + ")," +
                                "('Gomez United', 2, " + R.mipmap.logo_gomez + ")," +
                                "('Grêmio E-Sports', 2, " + R.mipmap.logo_gremio + ")," +
                                "('Gunners FC', 2, 0)," +
                                "('Hardline E-Sports', 2, " + R.mipmap.logo_hardline + ")," +
                                "('Honved E-sports', 2, " + R.mipmap.logo_honved + ");");
                        db.execSQL("insert into manager (nome, telefone, email, clube) values ('Marcus Vinicius ','13 991921333','Akoltyfc@gmail.com', (select c.id from clube c where c.nome = 'Akolty FC'))," +
                                "('Carlos Henrique da Silva do Nascimento','11984526070','carlos_hsn@hotmail.com', (select c.id from clube c where c.nome = 'All Blacks Team'))," +
                                "('Ademar Peixoto','11970354448','ademar_peixoto@live.com', (select c.id from clube c where c.nome = 'ALL GAZARRA E-SPORTS'))," +
                                "('Leonardo Caldas','+1 (616)2924180','lcaldas@kcconline.org', (select c.id from clube c where c.nome = 'American Boys FC'))," +
                                "('Caio ','21999729475','caioniemeyer@gmail.com', (select c.id from clube c where c.nome = 'Amigos Da Cevada '))," +
                                "('Junior Verde','(11) 98618-0166','cfrajunior@gmail.com', (select c.id from clube c where c.nome = 'ARENA FIFA E-SPORTS'))," +
                                "('Rickson da Silva Mendonça','22997339808','Arsenalcoolfc1@gmail.com', (select c.id from clube c where c.nome = 'Arsenalcool FC'))," +
                                "('LUCAS PASSOS LIRA','21964811249','lucasplira2@gmail.com', (select c.id from clube c where c.nome = 'Atlético D.N'))," +
                                "('Tiago Morais','085 988363738','matapatopato@hotmail.com', (select c.id from clube c where c.nome = 'Barça FC'))," +
                                "('João Victor Moreira Caetano de Almeida','21994816304','joaovictormoreira4@gmail.com', (select c.id from clube c where c.nome = 'Barça FC'))," +
                                "('Thiago','(41) 99631-6436','thibarzilai@gmail.com', (select c.id from clube c where c.nome = 'Barzilai'))," +
                                "('Talles','16991115231','tallescarvalhofilmes@gmail.com', (select c.id from clube c where c.nome = 'BIRDEAUX FC'))," +
                                "('GUSTAVO DE SOUZA','48 988023069','guzsouza@gmail.com', (select c.id from clube c where c.nome = 'Bixcoito de Futebol Virtual'))," +
                                "('Alessandro Bizzo ','21972241217','bp.manager@outlook.com', (select c.id from clube c where c.nome = 'Black Pumas'))," +
                                "('sidmar ','(44) 99740-8583','dimararaujo@uol.com.br', (select c.id from clube c where c.nome = 'BOLEIROS E-SPORTS'))," +
                                "('Jair Coelho Filho','21971222988','jaircoelhofilho@hotmail.com', (select c.id from clube c where c.nome = 'Bonde da C'))," +
                                "('Guilherme Ferreira ','44 9 9888-6629','Guilhermeamorim98@hotmail.com', (select c.id from clube c where c.nome = 'Bravos FC'))," +
                                "('Romário Lopes de Brito Junior','27992769792','romariol_brito@hotmail.com', (select c.id from clube c where c.nome = 'Bravos FC Xone'))," +
                                "('Davi de Souza Oliveira','21980378738','Daviazuos@gmail.com', (select c.id from clube c where c.nome = 'brazilian storm'))," +
                                "('Venicio','15087402617','vinny-20@live.com', (select c.id from clube c where c.nome = 'BRAZILIAN STORM E-SPORTS'))," +
                                "('Wellington José Duarte ','(11) 96639-2378','wj.duarte88@gmail.com', (select c.id from clube c where c.nome = 'C A Pojeto juniors'))," +
                                "('Marcio','11954395676','familiaticoloko@gmail.com', (select c.id from clube c where c.nome = 'CANELAS FC'))," +
                                "('Pedro Paulo','21996272637','ppauloms@hotmail.com', (select c.id from clube c where c.nome = 'Cariocas FR'))," +
                                "('Alyton Ney Montalvão Madureira','(35) 99707-4028','alytonney@yahoo.com.br', (select c.id from clube c where c.nome = 'Castelo e-Sports'))," +
                                "('Mailson','984051274','Annyfran2009@hotmail.com', (select c.id from clube c where c.nome = 'Caucaia fifeiros'))," +
                                "('Ericson Caldana','(11) 99450-8787','caldana.t.i@gmail.com', (select c.id from clube c where c.nome = 'Champions Fifa Br E-Sports'))," +
                                "('Arildo Bissoli Bicas','27998297679','arildobicas@gmail.com', (select c.id from clube c where c.nome = 'Coroas'))," +
                                "('Otto Rezende Kohler','31975104747','ottobrrezende@gmail.com', (select c.id from clube c where c.nome = 'Cruzoeiro E-Sports'))," +
                                "('Jonathan Telles de Oliveira','(21) 99154-0748','alinemothana@gmail.com', (select c.id from clube c where c.nome = 'Dangers CR'))," +
                                "('Cristian da Silva','(54) 99137-6744','cristianbsilva@gmail.com', (select c.id from clube c where c.nome = 'Diabos Vermelhos'))," +
                                "('Lucas','19997416082','lukzhardy@gmail.com', (select c.id from clube c where c.nome = 'Diavolo e-Sports'))," +
                                "('Thiago Freitas','(37) 99861-2923','thiagofreitasromano@outlook.com', (select c.id from clube c where c.nome = 'Dibrentus'))," +
                                "('Rafael ','(15) 99792-8268','Rafael.vianaaa@hotmail.com', (select c.id from clube c where c.nome = 'Ditadores Es'))," +
                                "('Diogo','11 1970427616','Diogomgames@gmail.com', (select c.id from clube c where c.nome = 'DKG UNITED '))," +
                                "('Jyordan Gomes','21968853832',' jyordangomes20@gmail.com ', (select c.id from clube c where c.nome = 'Dragões da Real E-Sports'))," +
                                "('Warner Costa Oliveira Torres','(85) 99108-7797','warner-torres@hotmail.com', (select c.id from clube c where c.nome = 'EC Canarinho'))," +
                                "('Wesley','11994359240','weesley17@hotmail.com', (select c.id from clube c where c.nome = 'EC GALATICOS'))," +
                                "('Jonatha Rodrigues de Souza','11 97311-7729','Jonathapromotor@gmail.com', (select c.id from clube c where c.nome = 'EC Invictus '))," +
                                "('Rafael','48998457328','r90pro@gmail.com', (select c.id from clube c where c.nome = 'EC Marseille'))," +
                                "('Eduardo','31 971307706','ralphbarros_@hotmail.com', (select c.id from clube c where c.nome = 'EC Newcastle'))," +
                                "('Paulo Ricardo','(43) 99807-2576','prborges1@hotmail.com', (select c.id from clube c where c.nome = 'Exilados FC'))," +
                                "('Nikolas Schmidt','51991661221','npeters05@gmail.com', (select c.id from clube c where c.nome = 'FAMÍLIA FC'))," +
                                "('Lucas Mendes Carneiro Matos','7591926261','luckasz.mendes@gmail.com', (select c.id from clube c where c.nome = 'FBA E-SPORTS'))," +
                                "('Junior dias','(21) 986902202','Juniins2camila@hotmail.com', (select c.id from clube c where c.nome = 'Fc Gênesis '))," +
                                "('Luciano','(61) 98510-6645','lucianodf.imoveis@gmail.com', (select c.id from clube c where c.nome = 'FEA FV'))," +
                                "('Welton Gonçalves Silva','61982627902','wspacofitness@gmail.com', (select c.id from clube c where c.nome = 'Fenômenos P.C.L'))," +
                                "('Fabio','(83) 99615-7716','fclistenes@gmail.com', (select c.id from clube c where c.nome = 'FIFA CAMPINA'))," +
                                "('Matheus Silva','13997306671','theusz77@hotmail.com', (select c.id from clube c where c.nome = 'Fifanaticos EC'))," +
                                "('Jacque Marques','16981993315','jacqueline_marquessantos@hotmail.com', (select c.id from clube c where c.nome = 'Fly and Take'))," +
                                "('Francisco Neto','79999997298','franciscojlmneto@gmail.com', (select c.id from clube c where c.nome = 'FranGames E-Sports'))," +
                                "('Anderson Duarte','81981824447','andersonwfduarte@yahoo.com.br', (select c.id from clube c where c.nome = 'Fuleragi FC'))," +
                                "('Wesley Pires','11949775772','wesleyp.camargo11@gmail.com', (select c.id from clube c where c.nome = 'Full House FC'))," +
                                "('Fernando de Oliveira Vasconcellos','41996151322','fernandocwb88@HOTMAIL.COM', (select c.id from clube c where c.nome = 'Furacão E-SPORTS'))," +
                                "('Leonardo Moraes','(53) 99146-3794','galaticosfootballplayers@gmail.com', (select c.id from clube c where c.nome = 'Galáticos Football Players'))," +
                                "('Douglas Cardoso Mendonça','11947440417','mague.dougcm@outlook.com', (select c.id from clube c where c.nome = 'Game Over F.V'))," +
                                "('Igor','51985913367','igorpinkman@gmail.com', (select c.id from clube c where c.nome = 'Giants FC'))," +
                                "('DIOGO','21982120209','MOICANOVASCO@GMAIL.COM', (select c.id from clube c where c.nome = 'GOLD BRASIL'))," +
                                "('Daniel Gomez','(21) 98953-9679','gomezelisier@gmail.com', (select c.id from clube c where c.nome = 'Gomez United'))," +
                                "('Raphael Schena','(51) 99166-3488','raphaschena@hotmail.com', (select c.id from clube c where c.nome = 'Grêmio E-Sports'))," +
                                "('Jefferson Da Costa Santos ','(21) 98824-0513','Jefferson_JG@yahoo.com', (select c.id from clube c where c.nome = 'Gunners FC'))," +
                                "('Everton Igor','(11) 99871-3249','evigorferreira@gmail.com', (select c.id from clube c where c.nome = 'Hardline E-Sports'))," +
                                "('Arthur Neves De Carvalho','(11) 94020-6944','arthur.nevesc@gmail.com', (select c.id from clube c where c.nome = 'Honved E-sports'));");
                        db.execSQL("insert into faq (pergunta, resposta) values " +
                                "('Como me cadastro na CBFV ?','Faz login no www.11vs11.com.br e cria sua conta.')," +
                                "('Como colocar a foto de meu jogador no site ?','O jogador deve fazer login em sua conta e selecionar a opção de inserir foto, a imagem deve estar em 150x150 pixels e estar em jpg .')," +
                                "('Como crio um time ?','Faço login em minha conta e vou na opção criar time .')," +
                                "('Como inserir o escudo de meu time ?','O MANAGER deve fazer login e selecionar pra inserir escudo da equipe .\n" +
                                "A imagem tem que estar em jpg e na resolução 150x150')," +
                                "('Como me transfiro para um time ou como contrato jogadores ?','Faz login/ No menu transferências solicita o clube que deseja se transferir e aguarda a aprovação do MANAGER.\n" +
                                "Ou recebe a proposta do MANAGER que deve ir em Transferências / Procurar jogadores em seu quadro de avisos em seu login e mandar a proposta')," +
                                "('Consigo mudar meu id no site, depois de cadastrado?','Pode procurar um ADM e justificar o motivo da mudança de nome para aprovação da administração, não poderá haver mudanças com campeonato em andamento.')," +
                                "('Como participo dos campeonatos CBFV ?','Faz cadastro em nosso site e acompanha nossos informativos sobre competições .\n" +
                                "Para inscrever deve fazer login e procurar campeonatos abertos.')," +
                                "('Qual o número mínimo de jogadores que meu time tem que ter para jogar os campeonatos CBFV?','Todas as plataformas devem ter um mínimo de 11 jogadores inscritos .\n" +
                                "Algumas competições tem requisitos diferentes mínimos , pode consultar o regulamento.')," +
                                "('Qual a tolerância pra pedir W.O? ','10 minutos de tolerância .')," +
                                "('Como Reporta uma partida oficial?','O MANAGER deve fazer login e selecionar a opção reportar jogos, tem que respeitar o prazo de 24 horas e as 3 imagens são obrigatórias .')," +
                                "('Como funciona o ranking CBFV ?','É um rankeamento baseado no ranking mundial de seleções da fifa mas alguns elementos de álgebra , todo clube ao se cadastrar na CBFV começa com 100 pontos no ranking, o desempenho do time vai fazer com que adquira pontos, times piores colocados no ranking ganham mais pontos contra times melhores colocados e times com melhor posição no ranking ganham menos pontos contra times inferiores no ranking.')," +
                                "('As estatísticas do pro no CBFB do antigo site Vão se manter no novo ou vai zerar tudo ?','As estatísticas serão migradas e divididas por 10, para reajuste do coeficiente a casa das centenas .')," +
                                "('Como é a escolha de jogadores para a seleção brasileira?','Apenas jogadores que atuam pela CBFV podem fazer parte da seleção CSVP, os jogadores são convocados conforme desempenho e destaque nas competições , mas as escolhas são apenas do técnico da seleção . A direção CBFV não interfere na convocação . Apenas temos seleção no momento na plataforma ps4!');");
                    } catch (Exception e) {
                        System.out.println();
                    }
                    break;
            }
        }
    }

    public List<Manager> getManagers(int plataforma) {
        SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(DB_VERSION);
        db.setLocale(Locale.getDefault());

        StringBuilder sql = new StringBuilder("select");
        sql.append(" m.id, m.nome, m.telefone, m.email, c.nome as nomeClube, c.drawable as drawableClube, p.nome as nomePlataforma");
        sql.append(" from manager m");
        sql.append(" join clube c on c.id = m.clube");
        sql.append(" join plataforma p on p.id = c.plataforma");
        sql.append(" where p.id = ");
        sql.append(plataforma);
        sql.append(" order by m.nome, c.nome");

        Cursor cursor = db.rawQuery(sql.toString(), null);
        cursor.moveToFirst();

        List<Manager> managers = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Manager manager = new Manager(cursor);
            managers.add(manager);
            cursor.moveToNext();
        }

        cursor.close();
        return managers;
    }

    public List<FAQ> getFaqs(){
        SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(DB_VERSION);
        db.setLocale(Locale.getDefault());

        StringBuilder sql = new StringBuilder("select * from faq order by id");
        Cursor cursor = db.rawQuery(sql.toString(), null);
        cursor.moveToFirst();
        List<FAQ> faqs = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            FAQ faq = new FAQ(cursor);
            faqs.add(faq);
            cursor.moveToNext();
        }

        cursor.close();
        return faqs;
    }
}
