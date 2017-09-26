package br.com.a11vs11.app.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.a11vs11.app.model.Manager;

/**
 * Created by TDR on 25/09/2017.
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

        SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, SQLiteDatabase.OPEN_READONLY, null);

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
                        db.execSQL("insert into clube (nome, plataforma) values ('Akolty FC', 1);" +
                                "insert into clube (nome, plataforma) values ('All Blacks Team', 1);" +
                                "insert into clube (nome, plataforma) values ('ALL GAZARRA E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('American Boys FC', 1);" +
                                "insert into clube (nome, plataforma) values ('Amigos Da Cevada ', 2);" +
                                "insert into clube (nome, plataforma) values ('ARENA FIFA E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('Arsenalcool FC', 1);" +
                                "insert into clube (nome, plataforma) values ('Atlético D.N', 2);" +
                                "insert into clube (nome, plataforma) values ('Barça FC', 2);" +
                                "insert into clube (nome, plataforma) values ('Barzilai', PC);" +
                                "insert into clube (nome, plataforma) values ('BIRDEAUX FC', PC);" +
                                "insert into clube (nome, plataforma) values ('Bixcoito de Futebol Virtual', 2);" +
                                "insert into clube (nome, plataforma) values ('Black Pumas', 1);" +
                                "insert into clube (nome, plataforma) values ('BOLEIROS E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('Bonde da C', 2);" +
                                "insert into clube (nome, plataforma) values ('Bravos FC', PC);" +
                                "insert into clube (nome, plataforma) values ('Bravos FC Xone', 1);" +
                                "insert into clube (nome, plataforma) values ('brazilian storm', 2);" +
                                "insert into clube (nome, plataforma) values ('BRAZILIAN STORM E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('C A Pojeto juniors', 2);" +
                                "insert into clube (nome, plataforma) values ('CANELAS FC', PC);" +
                                "insert into clube (nome, plataforma) values ('Cariocas FR', 2);" +
                                "insert into clube (nome, plataforma) values ('Castelo e-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Caucaia fifeiros', 2);" +
                                "insert into clube (nome, plataforma) values ('Champions Fifa Br E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Coroas', PC);" +
                                "insert into clube (nome, plataforma) values ('Cruzoeiro E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Dangers CR', 2);" +
                                "insert into clube (nome, plataforma) values ('Diabos Vermelhos', 2);" +
                                "insert into clube (nome, plataforma) values ('Diavolo e-Sports', 1);" +
                                "insert into clube (nome, plataforma) values ('Dibrentus', 1);" +
                                "insert into clube (nome, plataforma) values ('Ditadores Es', 2);" +
                                "insert into clube (nome, plataforma) values ('DKG UNITED ', 2);" +
                                "insert into clube (nome, plataforma) values ('Dragões da Real E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('EC Canarinho', 2);" +
                                "insert into clube (nome, plataforma) values ('EC GALATICOS', 2);" +
                                "insert into clube (nome, plataforma) values ('EC Invictus ', 1);" +
                                "insert into clube (nome, plataforma) values ('EC Marseille', 1);" +
                                "insert into clube (nome, plataforma) values ('EC Newcastle', 1);" +
                                "insert into clube (nome, plataforma) values ('Exilados FC', 1);" +
                                "insert into clube (nome, plataforma) values ('FAMÍLIA FC', PC);" +
                                "insert into clube (nome, plataforma) values ('FBA E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('Fc Gênesis ', PC);" +
                                "insert into clube (nome, plataforma) values ('FEA FV', 2);" +
                                "insert into clube (nome, plataforma) values ('Fenômenos P.C.L', 2);" +
                                "insert into clube (nome, plataforma) values ('FIFA CAMPINA', 2);" +
                                "insert into clube (nome, plataforma) values ('Fifanaticos EC', 2);" +
                                "insert into clube (nome, plataforma) values ('Fly and Take', PC);" +
                                "insert into clube (nome, plataforma) values ('FranGames E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Fuleragi FC', 2);" +
                                "insert into clube (nome, plataforma) values ('Full House FC', 2);" +
                                "insert into clube (nome, plataforma) values ('Furacão E-SPORTS', 2);" +
                                "insert into clube (nome, plataforma) values ('Galáticos Football Players', 1);" +
                                "insert into clube (nome, plataforma) values ('Game Over F.V', 2);" +
                                "insert into clube (nome, plataforma) values ('Giants FC', PC);" +
                                "insert into clube (nome, plataforma) values ('GOLD BRASIL', PC);" +
                                "insert into clube (nome, plataforma) values ('Gomez United', 2);" +
                                "insert into clube (nome, plataforma) values ('Grêmio E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Gunners FC', 2);" +
                                "insert into clube (nome, plataforma) values ('Hardline E-Sports', 2);" +
                                "insert into clube (nome, plataforma) values ('Honved E-sports', 2);");
                        db.execSQL("insert into manager (nome, telefone, email, clube) values ('Marcus Vinicius ','13 991921333','Akoltyfc@gmail.com', (select c.id from clube c where c.nome = 'Akolty FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Carlos Henrique da Silva do Nascimento','11984526070','carlos_hsn@hotmail.com', (select c.id from clube c where c.nome = 'All Blacks Team'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Ademar Peixoto','11970354448','ademar_peixoto@live.com', (select c.id from clube c where c.nome = 'ALL GAZARRA E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Leonardo Caldas','+1 (616)2924180','lcaldas@kcconline.org', (select c.id from clube c where c.nome = 'American Boys FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Caio ','21999729475','caioniemeyer@gmail.com', (select c.id from clube c where c.nome = 'Amigos Da Cevada '));" +
                                "insert into manager (nome, telefone, email, clube) values ('Junior Verde','(11) 98618-0166','cfrajunior@gmail.com', (select c.id from clube c where c.nome = 'ARENA FIFA E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Rickson da Silva Mendonça','22997339808','Arsenalcoolfc1@gmail.com', (select c.id from clube c where c.nome = 'Arsenalcool FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('LUCAS PASSOS LIRA','21964811249','lucasplira2@gmail.com', (select c.id from clube c where c.nome = 'Atlético D.N'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Tiago Morais','085 988363738','matapatopato@hotmail.com', (select c.id from clube c where c.nome = 'Barça FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('João Victor Moreira Caetano de Almeida','21994816304','joaovictormoreira4@gmail.com', (select c.id from clube c where c.nome = 'Barça FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Thiago','(41) 99631-6436','thibarzilai@gmail.com', (select c.id from clube c where c.nome = 'Barzilai'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Talles','16991115231','tallescarvalhofilmes@gmail.com', (select c.id from clube c where c.nome = 'BIRDEAUX FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('GUSTAVO DE SOUZA','48 988023069','guzsouza@gmail.com', (select c.id from clube c where c.nome = 'Bixcoito de Futebol Virtual'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Alessandro Bizzo ','21972241217','bp.manager@outlook.com', (select c.id from clube c where c.nome = 'Black Pumas'));" +
                                "insert into manager (nome, telefone, email, clube) values ('sidmar ','(44) 99740-8583','dimararaujo@uol.com.br', (select c.id from clube c where c.nome = 'BOLEIROS E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jair Coelho Filho','21971222988','jaircoelhofilho@hotmail.com', (select c.id from clube c where c.nome = 'Bonde da C'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Guilherme Ferreira ','44 9 9888-6629','Guilhermeamorim98@hotmail.com', (select c.id from clube c where c.nome = 'Bravos FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Romário Lopes de Brito Junior','27992769792','romariol_brito@hotmail.com', (select c.id from clube c where c.nome = 'Bravos FC Xone'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Davi de Souza Oliveira','21980378738','Daviazuos@gmail.com', (select c.id from clube c where c.nome = 'brazilian storm'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Venicio','15087402617','vinny-20@live.com', (select c.id from clube c where c.nome = 'BRAZILIAN STORM E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Wellington José Duarte ','(11) 96639-2378','wj.duarte88@gmail.com', (select c.id from clube c where c.nome = 'C A Pojeto juniors'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Marcio','11954395676','familiaticoloko@gmail.com', (select c.id from clube c where c.nome = 'CANELAS FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Pedro Paulo','21996272637','ppauloms@hotmail.com', (select c.id from clube c where c.nome = 'Cariocas FR'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Alyton Ney Montalvão Madureira','(35) 99707-4028','alytonney@yahoo.com.br', (select c.id from clube c where c.nome = 'Castelo e-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Mailson','984051274','Annyfran2009@hotmail.com', (select c.id from clube c where c.nome = 'Caucaia fifeiros'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Ericson Caldana','(11) 99450-8787','caldana.t.i@gmail.com', (select c.id from clube c where c.nome = 'Champions Fifa Br E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Arildo Bissoli Bicas','27998297679','arildobicas@gmail.com', (select c.id from clube c where c.nome = 'Coroas'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Otto Rezende Kohler','31975104747','ottobrrezende@gmail.com', (select c.id from clube c where c.nome = 'Cruzoeiro E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jonathan Telles de Oliveira','(21) 99154-0748','alinemothana@gmail.com', (select c.id from clube c where c.nome = 'Dangers CR'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Cristian da Silva','(54) 99137-6744','cristianbsilva@gmail.com', (select c.id from clube c where c.nome = 'Diabos Vermelhos'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Lucas','19997416082','lukzhardy@gmail.com', (select c.id from clube c where c.nome = 'Diavolo e-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Thiago Freitas','(37) 99861-2923','thiagofreitasromano@outlook.com', (select c.id from clube c where c.nome = 'Dibrentus'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Rafael ','(15) 99792-8268','Rafael.vianaaa@hotmail.com', (select c.id from clube c where c.nome = 'Ditadores Es'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Diogo','11 1970427616','Diogomgames@gmail.com', (select c.id from clube c where c.nome = 'DKG UNITED '));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jyordan Gomes','21968853832',' jyordangomes20@gmail.com ', (select c.id from clube c where c.nome = 'Dragões da Real E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Warner Costa Oliveira Torres','(85) 99108-7797','warner-torres@hotmail.com', (select c.id from clube c where c.nome = 'EC Canarinho'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Wesley','11994359240','weesley17@hotmail.com', (select c.id from clube c where c.nome = 'EC GALATICOS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jonatha Rodrigues de Souza','11 97311-7729','Jonathapromotor@gmail.com', (select c.id from clube c where c.nome = 'EC Invictus '));" +
                                "insert into manager (nome, telefone, email, clube) values ('Rafael','48998457328','r90pro@gmail.com', (select c.id from clube c where c.nome = 'EC Marseille'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Eduardo','31 971307706','ralphbarros_@hotmail.com', (select c.id from clube c where c.nome = 'EC Newcastle'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Paulo Ricardo','(43) 99807-2576','prborges1@hotmail.com', (select c.id from clube c where c.nome = 'Exilados FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Nikolas Schmidt','51991661221','npeters05@gmail.com', (select c.id from clube c where c.nome = 'FAMÍLIA FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Lucas Mendes Carneiro Matos','7591926261','luckasz.mendes@gmail.com', (select c.id from clube c where c.nome = 'FBA E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Junior dias','(21) 986902202','Juniins2camila@hotmail.com', (select c.id from clube c where c.nome = 'Fc Gênesis '));" +
                                "insert into manager (nome, telefone, email, clube) values ('Luciano','(61) 98510-6645','lucianodf.imoveis@gmail.com', (select c.id from clube c where c.nome = 'FEA FV'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Welton Gonçalves Silva','61982627902','wspacofitness@gmail.com', (select c.id from clube c where c.nome = 'Fenômenos P.C.L'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Fabio','(83) 99615-7716','fclistenes@gmail.com', (select c.id from clube c where c.nome = 'FIFA CAMPINA'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Matheus Silva','13997306671','theusz77@hotmail.com', (select c.id from clube c where c.nome = 'Fifanaticos EC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jacque Marques','16981993315','jacqueline_marquessantos@hotmail.com', (select c.id from clube c where c.nome = 'Fly and Take'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Francisco Neto','79999997298','franciscojlmneto@gmail.com', (select c.id from clube c where c.nome = 'FranGames E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Anderson Duarte','81981824447','andersonwfduarte@yahoo.com.br', (select c.id from clube c where c.nome = 'Fuleragi FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Wesley Pires','11949775772','wesleyp.camargo11@gmail.com', (select c.id from clube c where c.nome = 'Full House FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Fernando de Oliveira Vasconcellos','41996151322','fernandocwb88@HOTMAIL.COM', (select c.id from clube c where c.nome = 'Furacão E-SPORTS'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Leonardo Moraes','(53) 99146-3794','galaticosfootballplayers@gmail.com', (select c.id from clube c where c.nome = 'Galáticos Football Players'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Douglas Cardoso Mendonça','11947440417','mague.dougcm@outlook.com', (select c.id from clube c where c.nome = 'Game Over F.V'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Igor','51985913367','igorpinkman@gmail.com', (select c.id from clube c where c.nome = 'Giants FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('DIOGO','21982120209','MOICANOVASCO@GMAIL.COM', (select c.id from clube c where c.nome = 'GOLD BRASIL'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Daniel Gomez','(21) 98953-9679','gomezelisier@gmail.com', (select c.id from clube c where c.nome = 'Gomez United'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Raphael Schena','(51) 99166-3488','raphaschena@hotmail.com', (select c.id from clube c where c.nome = 'Grêmio E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Jefferson Da Costa Santos ','(21) 98824-0513','Jefferson_JG@yahoo.com', (select c.id from clube c where c.nome = 'Gunners FC'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Everton Igor','(11) 99871-3249','evigorferreira@gmail.com', (select c.id from clube c where c.nome = 'Hardline E-Sports'));" +
                                "insert into manager (nome, telefone, email, clube) values ('Arthur Neves De Carvalho','(11) 94020-6944','arthur.nevesc@gmail.com', (select c.id from clube c where c.nome = 'Honved E-sports'));");
                    } catch (Exception e) {

                    }
                    break;
            }
        }
    }

    public List<Manager> getAllManagers(){
        SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
        db.setVersion(DB_VERSION);
        db.setLocale(Locale.getDefault());

        StringBuilder sql = new StringBuilder("select");
        sql.append(" m.id, m.nome, m.telefone, m.email, c.nome as nomeClube, p.nome as nomePlataforma");
        sql.append(" from manager m");
        sql.append(" join clube c on c.id = m.clube");
        sql.append(" join plataforma p on p.id = c.plataforma");
        sql.append(" order by p.nome, m.nome, c.nome");

        Cursor cursor = db.rawQuery(sql.toString(),null);
        cursor.moveToFirst();

        List<Manager> managers = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            managers.add(new Manager(cursor));
        }

        cursor.close();
        return managers;
    }
}
