package top.lionxxw;

/**
 * 、
 * Package top.lionxxw
 * Project effective_learning

 * Author lionxxw
 * Created on 2017/7/22 16:08
 * version 1.0.0
 */
public class xx
{
   /* public static void main(String[] args) {
        UserEmail mail = new UserEmail();
        mail.setType("xx");
        mail.setLogo("xx");
        mail.setEmail("xxx@163.com");
        List<EmailCreditBill> bills = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            int num = r.nextInt(5);
            EmailCreditBill bill = new EmailCreditBill();
            bill.setBillId(String.valueOf(i));
            bill.setEmail(mail.getEmail());
            bill.setBankId(String.valueOf(num));
            bill.setCardNumber("442" + r.nextInt(2));
            bill.setBankName("测试" + num);
            bills.add(bill);
        }
        mail.setBills(bills);

        System.out.println(JSON.toJSONString(mail));

        Map<String, List<EmailCreditBill>> collect = mail.getBills().stream().collect(toMap(bill->(bill.getBankId()+"|"+bill.getCardNumber()), (p) ->  ));
        System.out.println(collect);
    }*/
}
