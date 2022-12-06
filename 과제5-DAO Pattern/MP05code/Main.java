public class Main {
    public static void main(String[] args) {
        PasswordInfo p;
        PasswordInfoDao pwDao = new PasswordInfoDaoImpl();

        System.out.println("--- inserting...");
        p = new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
        pwDao.insert(p);
        p = new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
        pwDao.insert(p);

        System.out.println("--- finding all...");
        for (PasswordInfo pi : pwDao.findAll()) {
            System.out.println("reading... " + pi);
        }

        System.out.println("--- updating...");
        p = pwDao.findAll().get(0);
//        System.out.println(p);
        p.setUserId("smu1");
        pwDao.update(p.getUrl(), p);

        System.out.println("--- see if updated...");
        p = pwDao.findByKey("https://www.smu.ac.kr");
        if (p != null) {
            System.out.println(p);
        }
        else {
            System.out.println("null");
        }

        System.out.println("--- deleting...");
        pwDao.delete("https://www.smu.ac.kr");  // or personDao.delete(p);

        System.out.println("--- finding all after deleting...");
        for (PasswordInfo pi : pwDao.findAll()) {
            System.out.println("reading... " + pi);
        }
    }
}
