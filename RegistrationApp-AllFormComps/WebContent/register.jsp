<body  background="images/wallpaper1.jpg">
 <h1 style="color:red;text-align:center">Html to Servlet Communition using All form comps</h1>
 
 <form action="registerurl"   method="GET">
     <table border="0"  bgcolor="cyan"  align="center">
           <tr>
              <td> name :: </td>
              <td> <input type="text" name="name"  >
           </tr>
           <tr>
              <td> age :: </td>
              <td> <input type="password" name="age"  required> </td>
           </tr>
           <tr>
              <td> Address </td>
              <td> <textarea name="addrs"  row="5"  cols="15"  >
                      </textarea>
               </td>       
           </tr>
           
           <tr>
              <td> Gender </td>
              <td> <input type="radio" name="gender"  value="M" > Male &nbsp; &nbsp;
                        <input type="radio" name="gender"  value="F" checked > FeMale 
               </td>         
           </tr>
           
           <tr>
              <td> PhoneNumber </td>
              <td> <input type="tel" name="phone" required >  </td>         
           </tr>
           <tr>
              <td> Marital Status </td>
              <td> <input type="checkbox" name="ms"  value="marriaged" > Married  </td>         
           </tr>
           <tr>
              <td> Qualification </td>
              <td> <select name="qlfy"  required >
                              <option value="">-----select a value---</option>
                              <option value="engineer">B.Tech/B.E </option>
                              <option value="medico">MBBS/MD </option>
                              <option value="science">B.sc/M.sc </option>
                              <option value="computerApplications">BCA/MCA </option>
                              <option value="commerce">B.com/M.com </option>
                              <option value="arts">BA/MA </option>
                        </select>
               </td>         
           </tr>
            <tr>
              <td> Courses </td>
              <td> <select name="crs" multiple   >
                              <option value="oracle">Oracle pkg </option>
                              <option value="java"  selected>Java Pkg </option>
                              <option value="dotNet">Dot Net pkg </option>
                              <option value="ui">UI Technologies Pkg </option>
                              <option value="cloud">Cloud Pkg</option>
                        </select>
               </td>         
           </tr>
            <tr>
              <td> hobies </td>
              <td> 
                     <input type="checkbox" name="hb"  value="reading">Reading books &nbsp;
                     <input type="checkbox" name="hb"  value="sleeping">Meditation  &nbsp;
                     <input type="checkbox" name="hb"  value="roaming">Travelling &nbsp;
                     <input type="checkbox" name="hb"  value="watching">Watching TV &nbsp;
                     
                </td>         
           </tr>
             <tr>
              <td> Facebook url </td>
              <td> <input type="url" name="fbUrl"/>  </td>         
           </tr>
           <tr>
              <td>Date of Birth </td>
              <td> <input type="date" name="dob"  />  </td>         
           </tr>
           
       
           
            <tr>
              <td>Date Time of Birth </td>
              <td> <input type="datetime-local" name="dobLocal"/>  </td>         
           </tr>
           
             <tr>
              <td> Time of Birth </td>
              <td> <input type="time" name="time"/>  </td>         
           </tr>
           
           <tr>
              <td> Month of Birth </td>
              <td> <input type="month" name="month"/>  </td>         
           </tr>
           
           <tr>
              <td> Week of Birth </td>
              <td> <input type="week" name="week"/>  </td>         
           </tr>
           
           <tr>
              <td>Email Id </td>
              <td> <input type="email" name="email"  required/>  </td>         
           </tr>
           
            <tr>
              <td>Favourite color </td>
              <td> <input type="color" name="color"/>  </td>         
           </tr>
           
           <tr>
              <td>salary range(10k to 100k) </td>
              <td> <input type="range" name="salary"  min="10000"  max="100000"  title="select salary 10k to 100k" />  </td>         
           </tr>
           
          
           
            <tr>
              <td>Favorite number </td>
              <td> <input type="number" name="favNo"  />  </td>         
           </tr>
           
             <tr>
              <td>pin number </td>
              <td> <input type="text" name="pin"  />  </td>         
           </tr>
           
           <tr>
              <td>search words</td>
              <td> <input type="search" name="searchwords"  />  </td>         
           </tr>
           
            <tr>
              <td><input type="image"  src="images/submit.jpg" width="50"  height="50" value="register"></td>
              <td> <input type="reset" value="cancel" />  </td>         
           </tr>
          </table>
  </form>
  </body>
 <!-- request count ::  ${reqCount} --> 