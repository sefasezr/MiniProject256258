package AppointmentApp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentService {

    Scanner scan  = new Scanner(System.in);
    List<Appointment> appointments = new ArrayList<>();

    //12-randevu oluşturma metodu
    public void getAppointment(User user,DoctorService doctorService){
//13-dr listesi gösterilsin ve seçim yapılsın
        doctorService.printDoctors();
        System.out.println("Randevu almak istediğiniz doktoru seçiniz: (no)");
        int selectDoctor= scan.nextInt();
        scan.nextLine();
        if(doctorService.getDoctorById(selectDoctor)!=null){
            Doctor doctor = doctorService.getDoctorById(selectDoctor);
            if(!doctor.getDates().isEmpty()){
                System.out.println("Sayın "+user.getName()+", randevu alabileceğiniz tarihler :");
                for(int i = 0 ; i<doctor.getDates().size(); i++){
                    System.out.println((i+1)+" - "+doctor.getDates().get(i));
                }
                System.out.println("Randevu almak istediginiz tarihin numarasını giriniz: ");
                int select =scan.nextInt();
                scan.nextLine();
//15-tarih doğru seçildi mi
                if(select>0 && select<doctor.getDates().size()){
                    Appointment appointment = new Appointment(doctor,doctor.getDates().get(select-1),user);
                    this.appointments.add(appointment);
                    System.out.println("Sayın "+user.getName()+", randevu tarihiniz: "+doctor.getDates().get(select-1));
                    System.out.println("Randevu No: "+appointment.getId()+" ile randevu bilgilerinizi görüntüleyebilirsiniz.");
//16-randevu başarılı bir şekilde oluşturulunca seçilen tarih doktorun tkaviminden silinmeli
                    doctor.getDates().remove(select-1);
                }else{
                    System.out.println("Hatalı giriş!!!");
                }
            }else{
                System.out.println(doctor.getName()+"'un bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz");
            }
        }else{
            System.out.println("Hatalı giriş...");
        }
//17-kullanıcının girdigi randevu no ile eslesen randevu bilgilerini yazdır

    }
    public void printApp(){
        boolean isExist=true;
        System.out.println("Randevu no giriniz: ");
        int apoId = scan.nextInt();
        for(Appointment appointment : appointments){
            if(appointment.getId()==apoId){
                isExist=true;
                System.out.println("-------------------------------------------------");
                System.out.println(apoId+ " No'lu Randevu Bilgileri");
                System.out.println("Hasta adı: "+ appointment.getUser().getName());
                System.out.println("Branş: "+appointment.getDoctor().getDepartment());
                System.out.println("Doktor: "+appointment.getDoctor().getName());
                System.out.println("Randevu tarihi: "+appointment.getDate());
                System.out.println("-------------------------------------------------");
                break;
            }else{
                isExist=false;
            }
        }
        if(!isExist){
            System.out.println("Randevu bulunamadı");
        }
    }
}
