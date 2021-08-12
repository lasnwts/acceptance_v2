package ru.uralsib.acceptance.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
Этот класс осздан как источник данных для проверки
По сути вместо базы данных
 */
public final class Customers_init {

    private static Customers_init INSTANCE;

    //    Создаем список для проверки
    public ConcurrentMap<String, Customer> customers = new ConcurrentHashMap<>();

    public Customers_init() {
        this.init_customer();
    }

    public static Customers_init getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Customers_init();
        }
        return INSTANCE;
    }

    public ConcurrentMap<String, Customer> getCustomers() {
        return customers;
    }

    public Customer getId(String id) {
        if (customers.get(id) == null) {
            return new Customer();
        } else return customers.get(id);
    }

    public List<Customer> getCustomersJob(int salary) {
        List<Customer> customersList = new ArrayList<Customer>(getCustomers().values());
        List<Customer> cList = new ArrayList<Customer>();
        for (Customer customer : customersList) {
            if (customer.getSalary() == salary) {
                cList.add(customer);
            }
        }
        return cList;
    }

    public void addCustomers(Customer customer){
        customers.put(customer.getIdStr(),customer);
    }

    public Customer deleteCustomer(String id) {
        Customer customer = customers.get(id);
        customers.remove(id);
        if (customers.get(id) == null) {
            return new Customer();
        } else return customers.get(id);
    }

    //Инициализация
    public void init_customer() {
        customers.put("100001", new Customer(100001, "5888068", "Hulio", "Iglesias", "Rossia", "Manager", "RUR", 10000));
        customers.put("1", new Customer(1, "85e40e41-9041-48b4-95d5-3880c2427b56", "Randy", "Russell", "6380 Robert Locks Apt. 915West Donna, DE 09999", "Corporate investment banker", "Euro", 770));
        customers.put("2", new Customer(2, "c4655a50-50b5-42c5-bdc1-d58f892e6569", "Donald", "Ward", "71717 Holden Spring Suite 673Smithland, RI 84790", "Merchant navy officer", "Tongan paʻanga", 880));
        customers.put("3", new Customer(3, "2068a77f-62d5-484f-90a7-230f584e484c", "James", "Lewis", "447 Johnson Crossroad Apt. 983Humphreyton, OK 86601", "Podiatrist", "Vietnamese đồng", 550));
        customers.put("4", new Customer(4, "f2068b4a-5ccc-4698-bbb4-d21437711b17", "Laura", "Elliott", "7047 Cortez Lodge Suite 527West Zacharyside, WV 98535", "Chiropodist", "Costa Rican colón", 0));
        customers.put("5", new Customer(5, "3ae61114-32a8-4064-acdd-1f9553745015", "Samantha", "Little", "5704 Mccann Estates Suite 214Phillipston, DE 05870", "Historic buildings inspector/conservation officer", "Namibian dollar", 330));
        customers.put("6", new Customer(6, "c0d9ab8b-b971-42b4-998c-76dcdcac38e7", "Kimberly", "Hernandez", "Unit 1825 Box 7483DPO AA 30408", "Teacher, adult education", "West African CFA franc", 220));
        customers.put("7", new Customer(7, "05991393-d44a-40d3-9894-23f95ed5d251", "Anthony", "Perkins", "97645 Amanda RidgeJeffshire, MO 46262", "Technical author", "Falkland Islands pound", 660));
        customers.put("8", new Customer(8, "4e3469a1-475b-42be-a109-0201353da910", "Stephanie", "Knight", "80434 Melissa Squares Apt. 318Smithbury, AR 33975", "Advertising account executive", "Bahamian dollar", 990));
        customers.put("9", new Customer(9, "4222c707-0a70-4875-96f0-deee979d1760", "John", "Taylor", "84053 Shawn Lake Apt. 189South Linda, LA 75545", "Animator", "Israeli new shekel", 660));
        customers.put("10", new Customer(10, "81f96815-8c96-46bf-9db9-4c6a8312483c", "Travis", "Williams", "9630 Allen Crossing Suite 025East Michael, NM 73431", "Chartered certified accountant", "Paraguayan guarani", 110));
        customers.put("11", new Customer(11, "c915f8aa-59f6-41a1-bbf2-41d57db0c387", "Dean", "Mercado", "3959 Harrison ValleySouth Jessicafort, WY 78905", "Product designer", "Mauritian rupee", 110));
        customers.put("12", new Customer(12, "a0ba4398-fb62-4d05-98b9-969c335a4cd0", "Valerie", "Johnson", "85757 William Creek Apt. 906Kellymouth, NY 92393", "Exhibition designer", "Iranian rial", 770));
        customers.put("13", new Customer(13, "4f801af6-fb31-425d-bb51-b066522c1c7b", "Richard", "Cooke", "0577 John WellBarrybury, FL 94079", "Research scientist (maths)", "Turkmenistan manat", 990));
        customers.put("14", new Customer(14, "347ff150-a351-45d0-8ad6-334c8ed923e3", "David", "Garcia", "501 Mcdonald Manors Apt. 626Amychester, RI 17697", "Investment banker, operational", "Polish zloty", 440));
        customers.put("15", new Customer(15, "8b1fec5b-b2d7-4e52-8760-4a3db00da752", "Melanie", "Mckenzie", "9790 Bradley RoadsHernandezfort, VA 50477", "Programmer, systems", "Malawian kwacha", 990));
        customers.put("16", new Customer(16, "75fa394e-8b21-44df-9b38-eafaa64b05ed", "Allen", "Hill", "5343 Pena FieldKatelynchester, CT 89058", "Race relations officer", "Maldivian rufiyaa", 220));
        customers.put("17", new Customer(17, "96966538-a87c-45e7-b447-203f4cbc5432", "Troy", "Harris", "361 Amanda RoadNorth Sheenaland, ND 56167", "Chartered loss adjuster", "Liberian dollar", 660));
        customers.put("18", new Customer(18, "30625618-7ef1-48c7-adcc-3c7ccf21db1b", "Alisha", "Cohen", "85553 Joshua CrestEast Scottberg, VT 16853", "Scientist, biomedical", "Serbian dinar", 990));
        customers.put("19", new Customer(19, "e2840dc3-72b7-44d9-a917-3b6cd307f29c", "Thomas", "Munoz", "445 Nathan HillCalvinstad, MI 23139", "Exercise physiologist", "Sri Lankan rupee", 220));
        customers.put("20", new Customer(20, "c2aaf376-6613-4f1b-bc6a-21c1cf006c3a", "Lisa", "Torres", "474 Randy Haven Suite 483Hollyburgh, AL 84757", "Retail manager", "Russian ruble", 220));
        customers.put("21", new Customer(21, "6333de6b-1cfc-4073-8139-3e1fcbdd16e3", "Sara", "Taylor", "7192 Blackwell WalkBrandishire, LA 04569", "Administrator, Civil Service", "Russian ruble", 660));
        customers.put("22", new Customer(22, "abf0714a-39f4-4665-903c-1c876fd618be", "Cheryl", "Fleming", "787 Nathaniel Islands Suite 348Nicholasbury, MT 02814", "Engineer, electrical", "Guatemalan quetzal", 330));
        customers.put("23", new Customer(23, "4ecd4be8-9eec-42d7-a561-6cb60045cb5e", "Carol", "Brooks", "11285 Lisa Squares Apt. 093New Maryville, LA 51633", "Environmental education officer", "Gambian dalasi", 550));
        customers.put("24", new Customer(24, "6f615dfa-f5c1-4a81-8ceb-076509615a5b", "Timothy", "Miller", "45097 Carlson PortMichellefort, WY 98253", "Barrister", "Guernsey pound", 880));
        customers.put("25", new Customer(25, "c20cbc21-c1a0-4f82-a98e-ac2a380d730f", "Richard", "Wolf", "PSC 4086, Box 7543APO AA 45462", "Music tutor", "Mauritian rupee", 660));
        customers.put("26", new Customer(26, "63b46d60-98e4-4b99-9b6a-8029db536c90", "Brandy", "Morse", "22856 Williams ParksLake Jeffreyfort, HI 74501", "Energy engineer", "Swedish krona", 990));
        customers.put("27", new Customer(27, "f0b77fa3-7019-4ca0-911b-d0bbbdb7416d", "Gabriella", "Potts", "370 Miller IslandsJamestown, OR 98650", "Artist", "Nicaraguan córdoba", 990));
        customers.put("28", new Customer(28, "a15cdf98-3aa2-44e3-a6e9-346596b07636", "James", "Smith", "636 James Summit Suite 573Collinsburgh, RI 90041", "Lecturer, further education", "Qatari riyal", 220));
        customers.put("29", new Customer(29, "316c45cc-a3de-41c8-88ac-cf3d69b79e72", "Peter", "Jones", "66617 Thomas Greens Apt. 160South Saraborough, NH 75717", "Broadcast journalist", "Lesotho loti", 550));
        customers.put("30", new Customer(30, "6c460a55-200d-4b44-ad56-54e0680c6fa2", "Adam", "Santos", "763 Dylan Parks Suite 352East Charlestown, WY 03467", "Geophysical data processor", "Ghanaian cedi", 990));
        customers.put("31", new Customer(31, "5f07e1c1-b0ed-4f85-b20d-78c21a73017e", "Kelly", "Wall", "0168 Campbell LodgeEast Brian, KS 25382", "Physicist, medical", "Bosnia and Herzegovina convertible mark", 440));
        customers.put("32", new Customer(32, "e8d650c4-5a85-4f5a-a26a-507f70121c21", "Gregory", "Barnes", "4496 Matthew Plaza Apt. 706Tamaraborough, LA 42533", "Optician, dispensing", "Angolan kwanza", 660));
        customers.put("33", new Customer(33, "4ac6220e-bc31-4780-b318-bbe8b1e681b8", "Ashley", "Orr", "79877 Ray Bypass Suite 042Randyfurt, KY 42962", "Dramatherapist", "Sudanese pound", 770));
        customers.put("34", new Customer(34, "fc319406-6288-4e5b-9f02-ad7550f737b5", "Kevin", "Cox", "876 Angel Run Apt. 646Tonyamouth, NE 72326", "Designer, fashion/clothing", "Saudi riyal", 440));
        customers.put("35", new Customer(35, "411baaf7-a1a8-45be-bf32-e229b9b0386f", "Nathan", "Jacobs", "292 Henderson Viaduct Suite 543East Julieview, AZ 60259", "Higher education lecturer", "Moroccan dirham", 660));
        customers.put("36", new Customer(36, "bbc33e83-5152-47dd-a52e-55ffa62894b3", "Martin", "Guzman", "484 Costa RidgeJohnside, KY 65401", "Magazine features editor", "Botswana pula", 330));
        customers.put("37", new Customer(37, "b34c8b65-45ff-4690-9dbc-a73693656de4", "Emily", "Hernandez", "04029 Jessica TraceEast Andreaville, AK 76853", "Camera operator", "Malagasy ariar", 880));
        customers.put("38", new Customer(38, "531679c5-8f13-4bce-84a4-05a8ab780fd3", "Donald", "Short", "94459 Christine StravenueBurnsfort, DC 93587", "Counselling psychologist", "Somali shilling", 220));
        customers.put("39", new Customer(39, "798abc6d-2dea-4a75-8fe3-6f760ec2d9a4", "Amber", "Howard", "8933 Cheryl Ranch Suite 002West Allisonport, AR 58808", "Archivist", "Bahraini dinar", 220));
        customers.put("40", new Customer(40, "3404617f-65e5-46f7-af71-cee929567613", "Cathy", "Rose", "838 Ballard Forge Apt. 991Martinezview, WA 41077", "Conservation officer, nature", "Vanuatu vatu", 330));
        customers.put("41", new Customer(41, "de57d152-74dc-4701-8119-2b37cda61ddf", "Michael", "Reynolds", "21181 Daniels ShoreNew Erika, IA 61974", "Programme researcher, broadcasting/film/video", "Ugandan shilling", 440));
        customers.put("42", new Customer(42, "3e45586d-d75f-4242-8ada-aff46d0a98d7", "Matthew", "Gates", "01373 Megan ForksSouth Jerrystad, CA 46164", "Journalist, magazine", "Brunei dollar", 110));
        customers.put("43", new Customer(43, "515052bf-c6b5-4f11-a63f-6eb2677ffe95", "Brianna", "Ayers", "174 Avery Flats Suite 692North Bradley, IN 53086", "Seismic interpreter", "Mexican peso", 220));
        customers.put("44", new Customer(44, "7db3f20d-2fdb-45e2-9918-03fc836bfcc6", "Edward", "Rodriguez", "221 Adam DrivesStevenport, UT 16573", "Food technologist", "Pakistani rupee", 880));
        customers.put("45", new Customer(45, "5727fb3c-426f-4f02-bd16-fa8cab3fa155", "Brandy", "Johns", "79478 Jenna Union Apt. 363Sanchezview, NH 95955", "Radio broadcast assistant", "Bermudian dollar", 770));
        customers.put("46", new Customer(46, "cc2eb112-e9c9-4c2a-b64c-959862490933", "Tina", "Watson", "6457 Michele CliffsMasontown, NC 15684", "Journalist, broadcasting", "Sri Lankan rupee", 660));
        customers.put("47", new Customer(47, "c7103f3d-6bdd-4965-b720-bcd5fd273c18", "Roy", "Rogers", "454 Whitehead RampNorth Shannon, NE 26261", "Community arts worker", "Singapore dollar", 660));
        customers.put("48", new Customer(48, "e9a29c83-0d4c-49f2-991a-3b9ebfecd9e8", "Amy", "Johnson", "8950 Lawson WellsNorth Margaretbury, DC 51530", "Paramedic", "Guatemalan quetzal", 880));
        customers.put("49", new Customer(49, "f0c1b960-51ea-4501-afb6-73758a637e77", "Kevin", "Foster", "6276 Mitchell Springs Apt. 349Lake Matthewview, NV 37047", "Administrator, arts", "Qatari riyal", 550));
        customers.put("50", new Customer(50, "f17467f1-33a3-46a2-9067-d590613f7765", "Brandon", "Martinez", "574 Jessica Neck Suite 184Perkinston, NJ 38080", "Magazine journalist", "Lithuanian litas", 990));
        customers.put("51", new Customer(51, "e237dcb8-c207-4cf9-a05d-e7c5f1fa1b88", "Theresa", "Schmidt", "797 Erica Canyon Apt. 634East Maria, HI 29237", "Therapist, occupational", "Canadian dollar", 330));
        customers.put("52", new Customer(52, "34e14933-b611-4fd4-8edf-df06bdde1798", "Paul", "Adams", "Unit 0160 Box 9765DPO AA 71083", "Nature conservation officer", "Turkmenistan manat", 660));
        customers.put("53", new Customer(53, "fd36aa93-c97f-45b0-b0ef-051829eb71ef", "Alexandria", "Nelson", "02374 John VillagesElizabethshire, DC 33114", "Psychologist, prison and probation services", "Guyanese dollar", 330));
        customers.put("54", new Customer(54, "3ececcec-2cfd-4625-a9db-e5b92daf0690", "Amber", "Martinez", "0325 Pamela Crossing Suite 724North Ericfort, ID 46666", "Production engineer", "Bhutanese ngultrum", 990));
        customers.put("55", new Customer(55, "bb558715-e9b2-4dbd-a76c-dae159e6a6a7", "Brian", "Estrada", "50885 Allen Lakes Suite 298Mileshaven, IA 13630", "Designer, blown glass/stained glass", "Armenian dram", 330));
        customers.put("56", new Customer(56, "16f52b15-2c29-47d1-9b1d-a7eed039bfb3", "Brett", "Gray", "69210 Jose Well Suite 337Lake Charles, OK 75508", "Aid worker", "Bermudian dollar", 660));
        customers.put("57", new Customer(57, "7111d316-9bf4-4f7e-88d5-84ee82987c4e", "Allen", "Anthony", "69692 Liu Passage Suite 563New Rosemouth, OH 90106", "Volunteer coordinator", "Cambodian riel", 220));
        customers.put("58", new Customer(58, "da17d093-da94-42b4-a257-60811cc5c2d1", "Taylor", "Ritter", "77763 Ian Stream Apt. 092Lake Richardfort, DE 68456", "Magazine journalist", "Brunei dollar", 880));
        customers.put("59", new Customer(59, "d27f8e98-b40a-4e9e-bab7-333164cf5b49", "Kevin", "Williams", "448 Debra InletNorth Danielmouth, NE 14752", "Associate Professor", "Venezuelan bolívar", 220));
        customers.put("60", new Customer(60, "4b898bdb-2d3a-45dc-a595-29341171bf9a", "Karla", "Wong", "798 Brian Tunnel Suite 871Jeffreybury, WI 81445", "English as a second language teacher", "Eastern Caribbean dollar", 660));
        customers.put("61", new Customer(61, "49eeda0f-687a-47c9-8471-01a166c52671", "Jeanne", "Bennett", "7260 Zachary StreamMicheleport, LA 54986", "Engineer, petroleum", "Canadian dollar", 220));
        customers.put("62", new Customer(62, "dfadd755-67e1-4b4a-8f01-4125389c57d4", "Richard", "Crawford", "671 Richard Locks Apt. 047Justinmouth, SC 65504", "Engineer, petroleum", "Guernsey pound", 440));
        customers.put("63", new Customer(63, "eb67e44d-3bd9-4c80-8abd-eef4b34e7696", "Ryan", "Crawford", "2512 Cameron Villages Apt. 990Amymouth, TN 05857", "Airline pilot", "Philippine peso", 440));
        customers.put("64", new Customer(64, "46a0393e-74b7-4286-aa9c-98800ed4c210", "Cole", "Morgan", "50703 Michael Shoal Apt. 147Thomastown, ID 38310", "International aid/development worker", "Cayman Islands dollar", 550));
        customers.put("65", new Customer(65, "6796484d-fe06-4893-b836-d8fe1fd5a4c3", "Theodore", "Smith", "309 Barnes FerryNorth Jason, NY 31069", "Surveyor, hydrographic", "Indian rupee", 770));
        customers.put("66", new Customer(66, "6c2ca663-33b3-4e96-8db7-a8206a9b6b4a", "Patrick", "Butler", "783 Angela Port Apt. 551West Troy, CT 51478", "Personnel officer", "Namibian dollar", 770));
        customers.put("67", new Customer(67, "463bdb63-7c01-4d21-a5f2-25447be8191f", "Patricia", "Poole", "USS MendozaFPO AA 34440", "Sport and exercise psychologist", "Kazakhstani tenge", 990));
        customers.put("68", new Customer(68, "a5d7b8c6-0552-4629-b507-88d54b724342", "Zachary", "Smith", "823 Victor JunctionNorth Donaldhaven, TN 43843", "Production engineer", "Norwegian krone", 770));
        customers.put("69", new Customer(69, "bde490c0-3597-49c2-b4fe-080463353a5c", "Gary", "Moran", "8221 Smith LakeColleenberg, ID 96955", "Structural engineer", "Armenian dram", 0));
        customers.put("70", new Customer(70, "f905e756-1865-4dc4-9f89-0f6a40c7a507", "Brandon", "Morales", "354 Dunn Knolls Apt. 741East Kristen, HI 44370", "Dealer", "Mexican peso", 880));
        customers.put("71", new Customer(71, "21746df7-6054-4d84-ad3e-beb3aa347cbb", "Timothy", "Christensen", "783 Heather CoveRubenberg, MD 53524", "Surveyor, mining", "Central African CFA franc", 0));
        customers.put("72", new Customer(72, "4ac14cda-5918-4668-92a3-f601b1b28c87", "Sheila", "Parks", "01414 Anthony CurveCollinsberg, NE 29770", "Dietitian", "Afghan afghani", 110));
        customers.put("73", new Customer(73, "26680516-43b7-4015-baf9-ea51e73a54c6", "Michael", "Rubio", "1587 Hurst Fords Suite 306Bruceshire, KS 19784", "Health visitor", "Burundian franc", 110));
        customers.put("74", new Customer(74, "49f03486-f70e-4cbf-8449-d09184a3e195", "Erin", "Perez", "825 Little Prairie Suite 579West Scottview, NY 03554", "Interpreter", "Venezuelan bolívar", 880));
        customers.put("75", new Customer(75, "67192d6e-0d9c-412e-a067-22dc61262e96", "Misty", "George", "5381 Anna View Apt. 286Cantufurt, AZ 30708", "Chartered accountant", "Special drawing rights", 660));
        customers.put("76", new Customer(76, "9bebc93f-eb19-48b1-8520-8bf331d0b3ea", "Megan", "Pacheco", "94240 Phillips Forges Apt. 916Thomasburgh, GA 26631", "Engineer, technical sales", "Comorian franc", 330));
        customers.put("77", new Customer(77, "1c3b1c8e-bcad-4ab7-85fd-42866d9ce852", "Mary", "Cook", "497 Smith TraceJacquelineside, WI 06391", "Consulting civil engineer", "Cuban convertible peso", 0));
        customers.put("78", new Customer(78, "76d549f1-39f0-42fe-8341-46fd0e374a76", "Lindsey", "Lawson", "49425 Thomas Meadow Apt. 273South Lisa, GA 22527", "Landscape architect", "Saudi riyal", 770));
        customers.put("79", new Customer(79, "054d30ec-bbed-4abb-98a4-abc1d8d3e40a", "Seth", "Baker", "780 Bond VillagesFrankmouth, MN 79985", "Jewellery designer", "Bulgarian lev", 880));
        customers.put("80", new Customer(80, "d636aee2-377d-4909-83d5-a964004b90e6", "Madeline", "Pratt", "PSC 4515, Box 1786APO AP 73651", "Media buyer", "Haitian gourde", 550));
        customers.put("81", new Customer(81, "b96d1a42-fdfa-4574-9078-f8a7fbac2ab4", "Elizabeth", "Watkins", "353 Rodriguez Landing Apt. 230New Bryan, OK 97366", "Ranger/warden", "Swazi lilangeni", 330));
        customers.put("82", new Customer(82, "e495cf1e-8321-4f92-99f2-67488c8d3c33", "Matthew", "Williams", "8483 Rice Hills Suite 552North James, WI 64351", "Press sub", "Pound sterling", 880));
        customers.put("83", new Customer(83, "ec42aa91-fd8f-4e41-9718-ea7a2316d2d9", "Michael", "Smith", "USNV WolfFPO AE 53694", "Marketing executive", "Ugandan shilling", 660));
        customers.put("84", new Customer(84, "649458a5-d3f2-4921-ac4c-3d8a10a79b32", "Jessica", "Ortega", "39142 Christopher Landing Suite 014Colleenland, ND 08771", "Forest/woodland manager", "Czech koruna", 880));
        customers.put("85", new Customer(85, "a1787d3f-bcc9-4d5c-902c-7af86c3e4beb", "Tonya", "Gibson", "44410 David GlenLake Samuelmouth, SD 29263", "Chief Strategy Officer", "Costa Rican colón", 660));
        customers.put("86", new Customer(86, "ed0f55dd-a4c6-4c6b-83a3-2d39762197fa", "Danielle", "Benson", "51281 Thomas Landing Apt. 221Calvinton, LA 77145", "Public house manager", "Aruban florin", 770));
        customers.put("87", new Customer(87, "cbbe40c8-5968-4081-a71f-20ada4c8c11e", "Katherine", "Stone", "3105 Hunter Loaf Apt. 922Jeffreyland, IA 97460", "Building surveyor", "Swiss franc", 440));
        customers.put("88", new Customer(88, "7839b83a-563b-4e81-ba3e-16ce1f709ca0", "Gregory", "White", "5679 Combs Center Suite 224Laurenfurt, MO 34588", "Air traffic controller", "Cuban peso", 550));
        customers.put("89", new Customer(89, "1ceba29f-7e9d-448b-9bf3-e735fbe7fdea", "Gregory", "Joyce", "5314 Marco CampVictoriaside, NH 44189", "Music therapist", "Hungarian forint", 0));
        customers.put("90", new Customer(90, "bad45851-e4b0-4764-835e-0faad612eae1", "Brenda", "Hawkins", "9135 Meghan CovesBuckbury, ND 42255", "Research officer, government", "Moroccan dirham", 220));
        customers.put("91", new Customer(91, "2ec84bfb-a237-4a0c-8422-1a6daf74d2c8", "Jessica", "Erickson", "77912 Flores EstateWest Brittney, KS 45112", "Chief Marketing Officer", "Belize dollar", 110));
        customers.put("92", new Customer(92, "1cfb5708-e5d7-4432-a751-1aa53f8b4878", "Jessica", "Barry", "Unit 2979 Box 0649DPO AE 75538", "Engineer, energy", "Burundian franc", 880));
        customers.put("93", new Customer(93, "32c5bce0-de10-49ec-8dc8-aa0c2f947075", "Donna", "Lee", "3671 Linda CrossroadWest Isabella, MO 47445", "Ship broker", "Swedish krona", 770));
        customers.put("94", new Customer(94, "9391212f-04d1-4806-852e-a34960071d45", "Daniel", "Garcia", "302 Cox Oval Suite 670Carlfort, AR 27110", "Engineer, biomedical", "Costa Rican colón", 550));
        customers.put("95", new Customer(95, "a4e91040-766b-48e6-8bc3-e04e43e98b1c", "Thomas", "Gonzalez", "325 Valerie Cove Apt. 793West Nicole, AL 23232", "Radiographer, therapeutic", "Jordanian dinar", 440));
        customers.put("96", new Customer(96, "0152d84a-728a-4830-8c57-506889ba2b9f", "Nicole", "Thompson", "394 Daugherty MeadowKevinhaven, PA 03507", "Public relations officer", "Tajikistani somoni", 770));
        customers.put("97", new Customer(97, "9cabedca-9230-4829-94f1-859db9413841", "Beth", "Holmes", "USCGC JamesFPO AE 19978", "Airline pilot", "Saint Helena pound", 770));
        customers.put("98", new Customer(98, "d2fbfa5d-6920-4369-b8fa-3e5ed7201684", "Renee", "Harvey", "983 Nicholas GardensNorth Thomas, UT 44692", "Counselling psychologist", "Bhutanese ngultrum", 770));
        customers.put("99", new Customer(99, "42656c85-5d43-4dcc-b41c-e5b50d333a6c", "Gregory", "Hess", "230 Wilson Ramp Suite 466Dennisbury, IA 16974", "Occupational therapist", "Russian ruble", 330));
        customers.put("100", new Customer(100, "b1d3ed54-091c-4405-871a-67d9c422cc4f", "John", "Smith", "96276 Julie ShoreDavistown, OK 39879", "Drilling engineer", "Bermudian dollar", 330));
        customers.put("101", new Customer(101, "ec3addba-2200-4a76-b638-f5798045e56d", "Derek", "King", "Unit 0074 Box 7309DPO AE 28344", "Teacher, special educational needs", "Renminbi", 110));
        customers.put("102", new Customer(102, "c5c1e781-2360-4fe1-a567-113d55543f01", "Timothy", "Small", "1525 Ryan Garden Apt. 537East Masonstad, OK 76518", "Psychotherapist", "Thai baht", 660));
        customers.put("103", new Customer(103, "6965ca67-e700-4982-8f15-1f08776d331c", "Michael", "Dillon", "Unit 1734 Box 5017DPO AA 41958", "Nurse, learning disability", "Kazakhstani tenge", 440));
        customers.put("104", new Customer(104, "e29274c3-cf1f-49be-a533-74af24fdf062", "Jennifer", "Jordan", "2230 Cole FreewayAliceton, IL 84369", "Graphic designer", "New Zealand dollar", 990));
        customers.put("105", new Customer(105, "cbfbf9e8-b6ec-4fd4-911b-14f5996af5b2", "Jimmy", "Martinez", "925 Carol Meadow Suite 625Swansonbury, MD 09418", "Pharmacologist", "Maldivian rufiyaa", 0));
        customers.put("106", new Customer(106, "a2f9cfcf-b9c8-432b-8aa9-4fe9a97aa998", "Lucas", "Thomas", "55463 Stephanie LocksEvansberg, NH 86902", "Ergonomist", "Japanese yen", 770));
        customers.put("107", new Customer(107, "578f52b1-9b3d-49b9-b4df-d9db6add0f6f", "Michelle", "Fletcher", "025 Lisa Ranch Suite 830Lake Raymond, MN 01985", "Chartered legal executive (England and Wales)", "Swiss franc", 990));
        customers.put("108", new Customer(108, "c6a36020-b73d-411b-b559-fd96dd0c4a31", "Patricia", "Jackson", "960 Angel Locks Suite 713East Laurie, NH 70201", "Chartered legal executive (England and Wales)", "Bosnia and Herzegovina convertible mark", 880));
        customers.put("109", new Customer(109, "7473f36d-c1f9-4ebf-aa20-23002a4d61da", "Joseph", "Long", "Unit 2980 Box 0734DPO AP 88893", "Exercise physiologist", "Japanese yen", 220));
        customers.put("110", new Customer(110, "0404f33e-cff6-4eab-8105-9b2a5323b77c", "Steven", "Morrison", "40069 Castillo Forge Apt. 416Bushtown, NV 63285", "Psychologist, occupational", "Icelandic króna", 660));
        customers.put("111", new Customer(111, "5899252f-45b8-4e92-95bd-6d78a6e2f1a3", "Brenda", "Owens", "073 Theresa Stream Suite 928Harthaven, TN 76647", "Jewellery designer", "United States dollar", 770));
        customers.put("112", new Customer(112, "7cdcfc09-6338-4b58-9b28-cc13e241313a", "Theodore", "Blackwell", "0015 Ashley ThroughwaySerranomouth, PA 11278", "Producer, radio", "Ethiopian birr", 110));
        customers.put("113", new Customer(113, "25855c88-0f9d-4b2d-b5a7-973c2ac601a1", "Maurice", "Li", "58671 Rodriguez Tunnel Apt. 301Angelaton, GA 96406", "Surveyor, hydrographic", "Uruguayan peso", 330));
        customers.put("114", new Customer(114, "c3441227-766f-41cb-b0a9-9cd01d47765d", "Allison", "Cole", "USNS HarrisonFPO AP 12773", "Ambulance person", "Mongolian tugrik", 220));
        customers.put("115", new Customer(115, "498fac7e-3256-4a86-a13a-da872b912cc6", "Adam", "Simmons", "157 Cortez Curve Apt. 571Robertport, IN 32708", "Commercial art gallery manager", "Armenian dram", 110));
        customers.put("116", new Customer(116, "190116f1-9c30-4915-abc6-ba605375a5b5", "Kimberly", "Williams", "8007 Rachel JunctionSouth Lisa, NY 38781", "Producer, radio", "Netherlands Antillean guilder", 440));
        customers.put("117", new Customer(117, "bb84667e-e4f0-4702-bffe-1c35e78bc7c6", "Kyle", "Griffin", "9371 Villanueva Keys Apt. 423Smithville, DE 99150", "Physiological scientist", "Singapore dollar", 660));
        customers.put("118", new Customer(118, "55a08d34-3c39-42e9-b0ee-a920346faaef", "Sarah", "Bean", "Unit 2701 Box 7669DPO AA 83563", "Psychologist, prison and probation services", "Samoan tālā", 330));
        customers.put("119", new Customer(119, "3b198360-3dfd-419d-ad24-b422fbcf3090", "Janet", "Walters", "463 Jenna ForksSarahmouth, NH 56234", "Arts administrator", "Ukrainian hryvnia", 990));
        customers.put("120", new Customer(120, "edd297be-bb2e-4273-a168-789fdf368b96", "Christopher", "Burnett", "6306 Bishop Vista Apt. 352North Victoria, TN 43353", "Ergonomist", "Brazilian real", 0));
        customers.put("121", new Customer(121, "e3803b4f-3f86-4e8e-91f5-ac70d2a96dca", "Rachel", "Burns", "446 Connie FallsJohnfort, NY 80526", "Manufacturing systems engineer", "Azerbaijani manat", 0));
        customers.put("122", new Customer(122, "410a2ead-19da-4ce8-8d1b-4e714e2bf23c", "Laura", "Hammond", "117 Carla RouteSouth Jeffreymouth, NE 07421", "Hydrographic surveyor", "Belize dollar", 770));
        customers.put("123", new Customer(123, "26ca4e7a-d1ae-4e77-8132-8c32b46d5402", "Rhonda", "Moreno", "5219 Anderson Park Apt. 167South Chloe, MI 08643", "Trading standards officer", "Netherlands Antillean guilder", 880));
        customers.put("124", new Customer(124, "27073c7c-2b8e-47ec-8abb-f973300cff67", "Jonathan", "Adkins", "PSC 8049, Box 1373APO AP 93002", "Multimedia specialist", "Azerbaijani manat", 110));
        customers.put("125", new Customer(125, "26a63acc-56af-4d99-87e2-066c8a48c867", "Ashley", "Johnson", "0219 Johnson Terrace Suite 231East Jessica, MA 28530", "Dispensing optician", "Jamaican dollar", 770));
        customers.put("126", new Customer(126, "c5ef0f24-4798-471e-899c-a7ffd16211b1", "Brittany", "Davis", "51217 Morales ParkwayLeahmouth, HI 07556", "Dramatherapist", "Macedonian denar", 330));
        customers.put("127", new Customer(127, "0a7de578-f2e2-4a5b-9fa2-f4161d84eb4e", "Juan", "Williams", "248 Morse LanePort Jillian, VA 53001", "Tax inspector", "Swazi lilangeni", 220));
        customers.put("128", new Customer(128, "52d8167b-bd20-4fc2-8eb8-06b0a1ff8722", "Luke", "Chang", "59081 Pugh Hills Apt. 273Moniqueport, LA 34911", "Ergonomist", "Uzbekistani soʻm", 990));
        customers.put("129", new Customer(129, "480a2cca-0095-442c-bee9-c33aeb8d7fba", "Lisa", "Mccoy", "6646 Campbell TurnpikePort Robertland, MT 57593", "Radio producer", "Brunei dollar", 0));
        customers.put("130", new Customer(130, "9d3d21b4-1306-4455-91bc-00cc9ee2fd0a", "Patricia", "Young", "52794 Jennings Ferry Suite 141Henrytown, NJ 84031", "Field trials officer", "São Tomé and Príncipe dobra", 0));
        customers.put("131", new Customer(131, "ddce1572-be2c-401f-a0a9-1084a5b2432d", "Joy", "Burns", "57785 Hodge SpurLake Jessicachester, MO 47004", "Advertising art director", "Chilean peso", 440));
        customers.put("132", new Customer(132, "a1eb7fd2-cf0b-4883-ad45-8cc610c7da77", "Victoria", "Delgado", "157 Burns TrailSouth Devin, AZ 64609", "Operational investment banker", "Chilean peso", 880));
        customers.put("133", new Customer(133, "969cef78-346f-45a8-aefa-709d3ca5d5e4", "Robert", "Flores", "466 Carpenter Dale Apt. 580Scottville, WV 96152", "Engineer, civil (contracting)", "Moldovan leu", 110));
        customers.put("134", new Customer(134, "3ba8dc15-ee5a-4a51-9ade-4dce2f20e0c3", "Micheal", "Kelly", "09471 Smith ForestSouth Sally, TN 90671", "Industrial buyer", "Thai baht", 0));
        customers.put("135", new Customer(135, "cf13d422-2163-49ce-99ee-61ff695a6971", "Brooke", "Hudson", "132 Barnett KeysNorth Samuelbury, MA 77370", "Psychologist, educational", "Guernsey pound", 0));
        customers.put("136", new Customer(136, "da4fe6db-e09a-40be-bdff-731228516725", "Samantha", "Smith", "780 Bennett PlaceTroyburgh, WA 55785", "Careers information officer", "United Arab Emirates dirham", 990));
        customers.put("137", new Customer(137, "31b04d5e-8170-46f3-af0b-b4081c426fcf", "James", "Long", "1167 Johnson Spur Apt. 281Armstrongborough, ND 15158", "Toxicologist", "Sierra Leonean leone", 0));
        customers.put("138", new Customer(138, "8b71312c-b9a9-454f-9e2c-5fb795b624d7", "Kerri", "Freeman", "70303 Morgan Drive Suite 722Adamchester, NE 51336", "Scientific laboratory technician", "Malagasy ariar", 880));
        customers.put("139", new Customer(139, "74bffc2e-7c15-4fd2-aae9-062f59be4093", "Dennis", "Mckay", "93848 Cynthia IslePort Manuel, ND 85514", "Embryologist, clinical", "Nepalese rupee", 110));
        customers.put("140", new Customer(140, "1e7790ad-2def-472c-a8d0-71fdfd8f2c45", "Allison", "Hamilton", "779 Banks Circle Suite 787Bradychester, MN 35726", "Commissioning editor", "Guyanese dollar", 990));
        customers.put("141", new Customer(141, "7278bbb2-f1bf-485a-8700-4097fc97a6dc", "Jason", "Baker", "8267 Hunter Rapids Apt. 126Ellistown, NH 65149", "Adult guidance worker", "Australian dollar", 990));
        customers.put("142", new Customer(142, "aa32ac8f-ec5b-4319-9bd2-3169d4b5c53c", "Jeff", "Short", "91718 Quinn Cape Apt. 130New Alexandra, NJ 74415", "Cytogeneticist", "Solomon Islands dollar", 770));
        customers.put("143", new Customer(143, "1a3d1fa8-e867-44d5-b7ee-462a0323b4a7", "Robert", "Bush", "5899 Montoya BranchNorth Paulville, NY 33777", "Advice worker", "Comorian franc", 550));
        customers.put("144", new Customer(144, "ac002c09-52b6-4b9d-826f-f992e6be0332", "Jonathan", "Ramirez", "813 Benjamin VistaNew Seanmouth, ND 25163", "Engineer, communications", "Saint Helena pound", 330));
        customers.put("145", new Customer(145, "ed3ae8b6-05d3-4045-9557-ded1050d2d7c", "Morgan", "Ryan", "23649 Jessica Forge Suite 356Kelleymouth, MA 64163", "Insurance claims handler", "Pound sterling", 880));
        customers.put("146", new Customer(146, "50bfb1f8-489c-4f08-8dde-c5629ba06e26", "Jeremy", "Mejia", "Unit 1163 Box 1906DPO AA 54800", "Financial risk analyst", "Central African CFA franc", 880));
        customers.put("147", new Customer(147, "c3f34f3d-cfa1-44e0-af05-31746f8bd7a2", "Alan", "Lucero", "7165 Gary GatewayPrinceside, WI 23218", "Administrator, Civil Service", "Mauritian rupee", 880));
        customers.put("148", new Customer(148, "06650341-512e-4911-a08e-d0fbfd2584f0", "Matthew", "Gray", "374 Goodman Drive Suite 333North Kathleen, KS 62759", "Records manager", "Brunei dollar", 550));
        customers.put("149", new Customer(149, "2090ecfe-93a7-463b-906f-279f35e42fd9", "Glen", "Perry", "USNV MartinezFPO AA 83522", "Editor, film/video", "Nigerian naira", 550));
        customers.put("150", new Customer(150, "c817ea9d-252f-4711-bb6f-81c776f816f0", "Alexander", "Christian", "239 Nicholas Knolls Apt. 665Benjaminborough, TX 05428", "Sales executive", "Norwegian krone", 0));
        customers.put("151", new Customer(151, "b47182a4-462d-4660-9683-6f032465b8a3", "Dawn", "Roberts", "21913 Bobby StreamGregoryville, VT 96336", "Forensic scientist", "Falkland Islands pound", 220));
        customers.put("152", new Customer(152, "d140e80f-dde4-4116-b5ac-02fed0f9ed0d", "Ashley", "Edwards", "927 Alexa Rue Apt. 932Theresamouth, ND 48416", "Charity officer", "Guatemalan quetzal", 0));
        customers.put("153", new Customer(153, "4ebf5ce3-1f4d-452d-8599-0cc28fcdf0ad", "Molly", "Romero", "04575 Sanders Isle Suite 447Warnerstad, KY 50501", "Animal technologist", "Nicaraguan córdoba", 330));
        customers.put("154", new Customer(154, "8b64bf47-9054-47c5-8d3c-4da491415c78", "Natalie", "Schneider", "Unit 4693 Box 4870DPO AA 85370", "Engineer, land", "Mauritian rupee", 220));
        customers.put("155", new Customer(155, "011fb109-dfd4-48f6-82ba-4147ce202e16", "Linda", "Oneal", "064 Richard GardensSouth Lisaton, HI 88595", "Ambulance person", "Canadian dollar", 440));
        customers.put("156", new Customer(156, "d8a9936d-13a1-41d0-afbf-5364f9f4483d", "Victoria", "Scott", "36722 Myers Springs Apt. 502East Kendrafurt, NV 10765", "Counselling psychologist", "Bolivian boliviano", 770));
        customers.put("157", new Customer(157, "aef32dbf-c9f0-4cfa-aff5-eebc555fc3ce", "Steven", "Harper", "63344 Thomas Manors Apt. 526Port Patrickshire, KS 69154", "Quantity surveyor", "Jordanian dinar", 550));
        customers.put("158", new Customer(158, "d3c0fa22-1973-496a-8d06-0fef6ac45a78", "Bonnie", "Norman", "521 Pamela CornerNew Thomas, IA 28876", "Radio producer", "Ghanaian cedi", 220));
        customers.put("159", new Customer(159, "a0a5812f-eaa6-4d1e-9c0b-eeca02dd860f", "Cheyenne", "Mills", "9671 James ParksChenville, OK 47024", "Advertising account planner", "Guinean franc", 990));
        customers.put("160", new Customer(160, "55949ee9-29e1-4376-8698-cf25aaeb6c4d", "Ronald", "Stewart", "821 Mann Ridges Suite 355South Williamborough, NE 56545", "Engineer, building services", "Dominican peso", 990));
        customers.put("161", new Customer(161, "40590593-7470-4661-a189-17548629e310", "Connie", "Johnson", "1815 Bryan Oval Apt. 096South Curtis, WY 35141", "Magazine journalist", "Armenian dram", 550));
        customers.put("162", new Customer(162, "3ea92b95-ff51-471e-8552-a629ee8bc295", "Heather", "Brown", "Unit 9393 Box 5123DPO AE 22522", "Education administrator", "Russian ruble", 220));
        customers.put("163", new Customer(163, "c832a23b-f4ad-4cf9-b7f6-5c5744f270ab", "Kathy", "Cervantes", "603 Christopher GatewayJamesfort, HI 42191", "Astronomer", "Iraqi dinar", 550));
        customers.put("164", new Customer(164, "578c471b-a671-4dee-9741-3f7c24803149", "Jason", "Cabrera", "43767 Jessica RoadSouth Valerie, NM 59668", "Health visitor", "Cape Verdean escudo", 990));
        customers.put("165", new Customer(165, "74d07623-013b-4275-a58f-028800b2a0aa", "Alexandria", "Williamson", "956 Rivera MotorwayMaryport, ID 75885", "Pathologist", "Uzbekistani soʻm", 330));
        customers.put("166", new Customer(166, "dd164d93-6ae0-42a6-9012-0875f6997bf5", "Autumn", "Shelton", "1517 Fisher Drive Suite 765North Vanessa, WV 27893", "Exhibitions officer, museum/gallery", "Lao kip", 330));
        customers.put("167", new Customer(167, "44c6cf6f-bad7-44c7-bdd7-481530501059", "Amy", "Cunningham", "927 Carpenter GardenWest Daniel, MI 69353", "Tourist information centre manager", "Saint Helena pound", 330));
        customers.put("168", new Customer(168, "917a23bc-f106-4aa0-a3e5-c57420b7b8ba", "Jeffery", "Moses", "8534 Parker RanchNorth Dianeview, CT 64024", "Scientist, audiological", "Tanzanian shilling", 330));
        customers.put("169", new Customer(169, "4af9ace6-0337-40dc-bb62-5149203b2634", "Joshua", "Daniels", "36583 Michael KnollNorth Karenview, ID 98627", "Transport planner", "Malagasy ariar", 0));
        customers.put("170", new Customer(170, "e825f0a7-5d96-44a1-8651-be49f6c49b4a", "Dana", "Glover", "855 Summer AvenueCruzmouth, CT 12232", "Administrator, local government", "Guinean franc", 770));
        customers.put("171", new Customer(171, "6ba5aed7-3e6d-4f15-a6ae-4fbf559b037f", "Michael", "Cisneros", "4121 Sara Expressway Apt. 109Charlesport, NE 41970", "Engineer, structural", "Israeli new shekel", 990));
        customers.put("172", new Customer(172, "1f09b796-00af-4629-922b-03aa9bf28a43", "William", "Rodriguez", "589 Sanchez Pines Suite 275West Corybury, LA 48412", "Water engineer", "Lebanese pound", 440));
        customers.put("173", new Customer(173, "f627fd0d-7799-4064-bdbb-fb37cdb6c8d8", "Erica", "Johnson", "USNV YorkFPO AE 34925", "Programmer, systems", "Comorian franc", 660));
        customers.put("174", new Customer(174, "92497dd4-a9c4-4e8d-9a57-1b8e242ede8e", "Jason", "Hardin", "426 Peter PathPort Christopher, MI 67657", "Emergency planning/management officer", "Kyrgyzstani som", 440));
        customers.put("175", new Customer(175, "cd47635e-dad2-4424-94bc-fe89ca74ea4d", "Barbara", "Mccarthy", "6981 Jacqueline Views Apt. 506Hannahport, NM 48161", "Legal secretary", "Iraqi dinar", 0));
        customers.put("176", new Customer(176, "2e666076-0ad8-4b5a-aa0c-0ae5868aff1f", "Anne", "Thomas", "51640 Bush SpurLake Traceyside, SD 17716", "Marine scientist", "Cayman Islands dollar", 660));
        customers.put("212", new Customer(212, "1a109d4d-a57c-48ad-95b9-49a0318b2655", "Angela", "Lara", "516 Phillips Street Apt. 140North Tonya, NY 91313", "Broadcast journalist", "Kuwaiti dinar", 220));
        customers.put("177", new Customer(177, "d90d6f89-594c-4c40-81a4-ad704756cefb", "Eric", "Williams", "250 Donald Trafficway Apt. 542East Lynnborough, NV 08974", "Outdoor activities/education manager", "Surinamese dollar", 0));
        customers.put("178", new Customer(178, "937f033c-f0e0-4709-a90d-4e4da3a42a57", "William", "Diaz", "537 Angela GrovesSouth Paul, KS 98021", "Trade union research officer", "Guyanese dollar", 550));
        customers.put("179", new Customer(179, "c574ecc0-2c7a-4659-83b0-7bff61b6ed08", "Michael", "Perry", "40657 Aaron Glen Suite 908Meganborough, IL 05759", "Associate Professor", "Vanuatu vatu", 330));
        customers.put("180", new Customer(180, "c7880768-a807-4fb0-9e07-d36d8e8b7eaf", "James", "Schroeder", "00462 Darren Extensions Suite 894West Kathybury, ME 68262", "Tree surgeon", "New Zealand dollar", 990));
        customers.put("181", new Customer(181, "20be29c3-506a-4db9-8efa-f7efd099ee16", "Jose", "Gilmore", "5192 Nguyen TrailVargashaven, DC 46522", "Lecturer, higher education", "Sudanese pound", 770));
        customers.put("182", new Customer(182, "d865192d-8d9c-4d44-986f-5878b3688100", "Charles", "Palmer", "USCGC HillFPO AP 38827", "Surveyor, planning and development", "Fijian dollar", 880));
        customers.put("183", new Customer(183, "c1905fe4-0212-4054-8c43-856fd64bd8e5", "Jennifer", "Juarez", "52429 Martin PointSmithland, WI 83569", "Photographer", "Haitian gourde", 990));
        customers.put("184", new Customer(184, "9f063365-0891-468e-a63b-3d1b065f3d3d", "Adam", "Wells", "21276 Soto LandAngelaland, IL 70678", "Regulatory affairs officer", "Philippine peso", 0));
        customers.put("185", new Customer(185, "88c1b822-1e04-4907-8c71-788c190d5ece", "Justin", "Stephenson", "714 Jeffrey ParkwaysNew Peterstad, AZ 93902", "Ranger/warden", "CFP franc", 770));
        customers.put("186", new Customer(186, "01bfb36b-2a58-4b47-9323-a3e5c278f2f4", "Randy", "Howard", "84412 David Bypass Apt. 872West Randymouth, VA 70812", "Archaeologist", "Turkmenistan manat", 770));
        customers.put("187", new Customer(187, "fb8ed028-ba2f-4744-bf30-16fea6caec36", "Stephen", "Villanueva", "620 Mario Lodge Suite 558New Tracyland, DC 27727", "Statistician", "Czech koruna", 660));
        customers.put("188", new Customer(188, "8312aaa8-76b0-4dab-846d-4a9320c58df8", "Scott", "Young", "866 Manuel MountainRichardfurt, WI 93821", "Speech and language therapist", "Angolan kwanza", 660));
        customers.put("189", new Customer(189, "2e4f9dee-8c49-46c3-bea4-d6e860000e1f", "Tonya", "Nelson", "PSC 7592, Box 0984APO AA 64395", "Retail banker", "Ugandan shilling", 660));
        customers.put("190", new Customer(190, "1facb428-a4b2-48e0-b067-57f0904e2d52", "Stephanie", "Koch", "PSC 7397, Box 9130APO AA 85539", "Horticultural therapist", "Swedish krona", 220));
        customers.put("191", new Customer(191, "8a2d571d-89bb-4d8d-8a02-a22695940edc", "Alexis", "Dean", "USCGC MartinezFPO AA 65901", "Art therapist", "Iranian rial", 0));
        customers.put("192", new Customer(192, "4ce93e0e-ca8a-4c17-980c-8b7aca563a66", "Troy", "Hayes", "348 Brian Ways Suite 516Anthonybury, AK 72525", "Claims inspector/assessor", "Israeli new shekel", 0));
        customers.put("193", new Customer(193, "142c7773-1423-41b6-b405-23eee6818585", "Nathaniel", "Lawson", "PSC 2883, Box 5367APO AE 37362", "Chartered loss adjuster", "Ethiopian birr", 110));
        customers.put("194", new Customer(194, "a5712372-754e-43f1-9579-fd5c5de5106b", "Victor", "Hall", "98860 Robinson MountainPetersonfort, NC 76209", "Corporate investment banker", "Canadian dollar", 330));
        customers.put("195", new Customer(195, "0adfd1c9-fc2e-4ba8-b00e-eabb67e0d4e1", "Gabrielle", "Marshall", "5623 Martinez SquareTorresville, CT 59531", "Educational psychologist", "Guernsey pound", 110));
        customers.put("196", new Customer(196, "d5311812-33e3-4ac3-ab31-3d8d2b02ca4a", "Lauren", "Reyes", "USNV JohnsonFPO AA 20292", "Equality and diversity officer", "Central African CFA franc", 550));
        customers.put("197", new Customer(197, "cf5770c0-9b65-4a7e-8e42-7102235b4903", "Joseph", "Jones", "5656 Andrew Path Suite 961Brandonfurt, ND 89805", "Technical sales engineer", "Haitian gourde", 770));
        customers.put("198", new Customer(198, "86d73a90-7251-4997-8774-36fa307e19b2", "Kristi", "Roman", "562 Stephen FordsGilbertburgh, CA 88220", "Teacher, special educational needs", "Maldivian rufiyaa", 330));
        customers.put("199", new Customer(199, "5d9a4170-285e-4ffc-9ac0-297e4f1bfee8", "Keith", "Brown", "257 Angela Spring Suite 323Theresaton, MA 40108", "Engineer, mining", "Hong Kong dollar", 220));
        customers.put("200", new Customer(200, "ab25d978-cd15-439a-a01f-6d282f6973f1", "Amber", "Edwards", "2008 Robert Bypass Suite 727Lake Jeffreymouth, AK 86999", "Systems analyst", "Bosnia and Herzegovina convertible mark", 220));
        customers.put("201", new Customer(201, "d6cf6de8-9e43-4d01-8822-70c138ddcc14", "Nicholas", "Chang", "08553 Alyssa GardensMillershire, OR 23869", "Herpetologist", "Zambian kwacha", 330));
        customers.put("202", new Customer(202, "24d1f931-b53a-4e92-b12b-4540e97aab63", "Kelly", "Wright", "67081 Gardner DriveNorth Tonyahaven, KS 88817", "Scientist, biomedical", "Omani rial", 550));
        customers.put("203", new Customer(203, "880095a4-d21a-4cae-a26f-614ff4b456a9", "Sean", "Knight", "21163 William FerryLake Brenda, AK 07982", "Therapist, drama", "Haitian gourde", 0));
        customers.put("204", new Customer(204, "43ed8f3d-0085-4311-8ae2-e8262c264c41", "Samantha", "Stevens", "413 Michael PlainsNew Jamesport, MA 26977", "Development worker, community", "Malagasy ariar", 440));
        customers.put("205", new Customer(205, "87dfa8e0-509f-4d2d-9ca4-5839f81fd1de", "Brooke", "Charles", "302 Mark Mountains Suite 590Port Christopherchester, MT 76028", "Meteorologist", "Netherlands Antillean guilder", 440));
        customers.put("206", new Customer(206, "4976da05-b7fd-4177-96e7-612c06fb4474", "Wendy", "Schmidt", "27467 Knapp RiverSouth Emily, AZ 52941", "Accounting technician", "Vanuatu vatu", 0));
        customers.put("207", new Customer(207, "8eef0702-1152-4fdd-b9e7-5b2b7393cadf", "Richard", "Green", "99086 Lisa RoadsNorth Sarahshire, RI 98918", "Theme park manager", "Yemeni rial", 0));
        customers.put("208", new Customer(208, "dc6b2052-56e8-4441-99c6-a99138c3f02e", "Anna", "Dean", "PSC 0753, Box 5895APO AP 56445", "Higher education lecturer", "Mongolian tugrik", 770));
        customers.put("209", new Customer(209, "4c8ff041-cc20-4a6c-bfa9-b1ce0393b253", "Stephanie", "Goodman", "3637 Jeffrey TunnelTylerborough, LA 28125", "Medical secretary", "Mozambican metical", 660));
        customers.put("210", new Customer(210, "a4abb3bc-b1ea-4ecb-839d-65880a081c9b", "Raymond", "Herrera", "6719 Christopher Circle Apt. 668Jacobshire, MS 79259", "Accountant, chartered management", "Bahraini dinar", 220));
        customers.put("211", new Customer(211, "bc3613db-ee84-4478-a8ed-f8f7c1084dde", "Angela", "Anderson", "740 Morrison Extensions Apt. 085Cynthiaville, MD 96300", "Herpetologist", "Colombian peso", 440));
        customers.put("213", new Customer(213, "702faa04-fa51-404f-a1ea-b3ed76d942c5", "Jennifer", "Banks", "276 Thompson ValleyRogertown, PA 81240", "Office manager", "Libyan dinar", 440));
        customers.put("214", new Customer(214, "45d5445a-9248-45dc-848f-d98f90b98866", "Anthony", "Rich", "07284 Amber Track Suite 035Brandtchester, MS 79924", "Financial manager", "Haitian gourde", 330));
        customers.put("215", new Customer(215, "e74008af-0191-44b7-bb07-6dd3f16364da", "Johnny", "Stone", "870 Chaney Lodge Apt. 960Bradberg, AZ 22027", "Commercial horticulturist", "New Zealand dollar", 660));
        customers.put("216", new Customer(216, "b5a25633-7fda-4815-bf72-faeb01e3a66e", "John", "House", "PSC 0918, Box 8915APO AE 79028", "Site engineer", "Seychellois rupee", 660));
        customers.put("217", new Customer(217, "1103765b-7918-42fd-a7a5-9722c6802190", "Andrew", "Dean", "915 Hines DriveJoshuashire, NV 34098", "Careers information officer", "São Tomé and Príncipe dobra", 0));
        customers.put("218", new Customer(218, "6572d131-1f5d-4c60-bf4f-1dca4c07d595", "Richard", "Martinez", "98845 Olsen Underpass Suite 347Shannonville, AZ 19957", "Publishing rights manager", "Swiss franc", 880));
        customers.put("219", new Customer(219, "cb9f9e73-bca5-4b18-8243-4ef404904d55", "Jonathan", "Bennett", "8104 Wade IslandsNew Harold, WV 93125", "Designer, television/film set", "Burmese kyat", 0));
        customers.put("220", new Customer(220, "5beb4985-21a6-404b-b251-62101ad39ad3", "Michelle", "Perry", "464 Paula Estate Suite 856Lake Jasonton, DC 54928", "Financial controller", "Vietnamese đồng", 330));
        customers.put("221", new Customer(221, "4cb989d8-e8cf-42f2-ab3d-87fa004f1354", "Bruce", "Johnson", "88627 Walters BrooksTracyburgh, MS 22710", "Claims inspector/assessor", "Chilean peso", 220));
        customers.put("222", new Customer(222, "a94905f5-dc07-46ca-8c7f-c4373eaaf22d", "Todd", "Howell", "892 Green Spurs Apt. 771Paigeville, NE 65970", "Horticulturist, commercial", "Guinean franc", 660));
        customers.put("223", new Customer(223, "2ec0bd31-4af3-4e92-a3f4-b3d208d3b65c", "Edward", "Johnson", "57793 Huynh EstatesLake Andrewside, MT 31704", "Structural engineer", "Mauritanian ouguiya", 0));
        customers.put("224", new Customer(224, "aa97ced9-e538-42ee-8a5a-006e967b4d01", "Jamie", "Wolf", "2869 Pugh Club Apt. 603North Ryanview, DC 74196", "Special educational needs teacher", "Cambodian riel", 220));
    }

}
