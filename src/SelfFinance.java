public class SelfFinance extends Student{
    @Override
    public String result(String allMarks) {
        String str = allMarks;
        String s;
        str = str.replaceAll("[^\\d]", " ");
        str = str.trim();
        str = str.replaceAll(" +", " ");
        if (str.equals(""))
            System.out.println("no numbers in string");
        s = str;

        String[] inStr = s.split(" ");
        int[] num = new int[inStr.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(inStr[i]);
        }

        int n = num.length;
        int[] subject = new int[n-3];
        int[] sports = new int[3];
        double gpas = 0.0;
        sports[0]=num[n-3];
        sports[1]=num[n-2];
        sports[2]=num[n-1];
        for(int i = 0; i<(n-3);i++)
        {
            subject[i]=num[i];
        }
        if(sports[0]==0)
        {sports[1]=0; sports[2]=0;}
        else
        {
            if(sports[1]>=75)
            {   gpas =(150+sports[1])/25;
                gpas = (double) Math.round((gpas)*10)/10;
            }else if(sports[1]>=60)
            {   gpas = (58+(0.9*sports[1]))/14;
                gpas = (double) Math.round((gpas)*10)/10;
            } else if (sports[1]>=40)
            {   gpas = 2+0.1*sports[1];
                gpas = (double) Math.round((gpas)*10)/10;
            }else
            {   gpas = 0;
            }
        }
        double[] cgpa = new double[n-1];
        cgpa[0] = gpas;
        cgpa[1] = sports[2];
        for (int i = 0; i<n-3;i++) {
            if (i % 2 == 0) {
                int a = subject[i];
                double b;
                if (a >= 75) {
                    b = (150 + a) / 25;
                    b = (double) Math.round((b) * 10) / 10;
                } else if (a >= 60) {
                    b = (58 + (0.9 * a)) / 14;
                    b = (double) Math.round((b) * 10) / 10;
                } else if (a >= 40) {
                    b = 2 + 0.1 * a;
                    b = (double) Math.round((b) * 10) / 10;
                } else {
                    b = 0;
                }
                cgpa[2 + i] = b;
            } else {
                cgpa[2 + i] = subject[i];
            }
        }

        double nu = 0.0, de = 0.0;
        for(int i=0;i<n-2;i=i+2)
        { nu = nu + (cgpa[i]*cgpa[i+1]);
          if(cgpa[i+1]>0)
                de=de+5;
        }

        double cpa = (double) Math.round((nu/de)*100)/100;
        String sfcpa = String.format("%.2f",cpa);

        return sfcpa;

    }
}
