package module.src;

import module.src.models.*;
import module.src.utils.DecimoTerceiro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) throws ParseException {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataContratacao = dateFormat.parse("2023-029-01");

            Colaborador devBack = new DevBackEnd("Test 1", "11111", "22222", 5000.0, "123", "M", dataContratacao, "PJ", "Jr", true);
            Colaborador designer = new Designer("Test 2", "22222", "22222", 2500.0, "321", "M", dataContratacao, "CLT", "Pleno", true);
            Colaborador devFront = new DevFrontEnd("Test 3", "333333", "33333", 5000.0, "213", "F", dataContratacao, "PJ", "Pleno", true);
            Colaborador techLeader = new TechLeader("Test 4", "444444", "33333", 8000.0, "231", "F", dataContratacao, "PJ", "Senior", true);

            //Back-end
            devBack.calcularValeTransporte();
            devBack.calcularValeRefeicao();
            devBack.calcularFgts();
            devBack.visualizar();
            DecimoTerceiro.calcularDecimoTerceiro(devBack.getSalario());

            System.out.println("-------------------------------------------------");
            //Designer
            designer.calcularValeTransporte();
            designer.calcularValeRefeicao();
            designer.calcularFgts();
            designer.visualizar();
            DecimoTerceiro.calcularDecimoTerceiro(designer.getSalario());
            System.out.println("-------------------------------------------------");
            //Front-End
            devFront.visualizar();
            DecimoTerceiro.calcularDecimoTerceiro(devFront.getSalario());
            System.out.println("-------------------------------------------------");
            //TechLeader
            techLeader.visualizar();
            DecimoTerceiro.calcularDecimoTerceiro(techLeader.getSalario());
            System.out.println("-------------------------------------------------");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
