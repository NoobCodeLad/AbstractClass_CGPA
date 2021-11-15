public class Aided extends Student{
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
        int[] subject = new int[n-6];
        int[] ncc = new int[3];
        int[] sports = new int[3];
        double gpan = 0,gpas = 0;
        sports[0] = num[n - 3];
        sports[1] = num[n - 2];
        sports[2] = num[n - 1];
        ncc[0]=num[n-6]; ncc[1]=num[n-5];ncc[2]=num[n-4];
        for(int i = 0; i<(n-6);i++)
        {
            subject[i]=num[i];
        }
        if(ncc[0]==0)
        {ncc[1]=0; ncc[2]=0;}
        else
        {
            if(ncc[1]>=75)
            {   gpan =(150+ncc[1])/25;
                gpan = (double) Math.round((gpan)*10)/10;
            }else if(ncc[1]>=60)
            {   gpan = ((58+(0.9*ncc[1]))/14);
                gpan = (double) Math.round((gpan)*10)/10;
            } else if (ncc[1]>=40)
            {   gpan = 2+0.1*ncc[1];
                gpan = (double) Math.round((gpan)*10)/10;
            }else
            {   gpan = 0;
            }
        }
        if(sports[0]==0)
            {sports[1]=sports[2]=0;}
        else
        {
            if(sports[1]>=75)
            {   gpas =(150+sports[1])/25;
                gpas = (double) Math.round((gpas)*10)/10;
            }else if(ncc[1]>=60)
            {   gpas = (58+(0.9*sports[1]))/14;
                gpas = (double) Math.round((gpas)*10)/10;
            } else if (ncc[1]>=40)
            {   gpas = 2+0.1*ncc[1];
                gpas = (double) Math.round((gpas)*10)/10;
            }else
            {   gpas = 0;
            }
        }
        double[] cgpa = new double[n-2];
        cgpa[0] = gpan;
        cgpa[1] = ncc[2];
        cgpa[2] = gpas;
        cgpa[3] = sports[2];
        for (int i = 0; i<n-6;i++) {
            if (i % 2 == 0) {
                int a = subject[i];
                double b;
                if (a >= 75) {
                    b = (150 + a) / 25;
                    b = (double) Math.round((b) * 10) / 10;
                } else if (a >= 60) {
                    b = (58 + (0.9 * a)) / 14;
                    b = (double) Math.floor((b) * 10) / 10;
                } else if (a >= 40) {
                    b = 2 + 0.1 * a;
                    b = (double) Math.round((b) * 10) / 10;
                } else {
                    b = 0;
                }
                cgpa[4 + i] = b;
            } else {
                cgpa[4 + i] = subject[i];
            }
        }
        double nu = 0.0, de = 0.0;
        for(int i=0;i<n-2;i=i+2)
        { nu = nu + (cgpa[i]*cgpa[i+1]);
          if(cgpa[i+1]>0)
                de=de+5;
        }

        double cpa = (double) Math.round((nu/de)*100)/100;
        String aidedcpa = String.format("%.2f",cpa);
        


        return aidedcpa;
    }
}
