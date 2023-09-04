
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>RegisterFrom</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f1f1f1;
}

.container {
	max-width: 700px;
	margin: 0 auto;
	padding: 20px;
	background-color: #ffffff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

.header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-bottom: 20px;
}

.company-info {
	flex: 1;
}

.company-info h2 {
	margin: 0;
}

.company-info p {
	margin: 0;
}

.photo-frame {
	width: 120px;
	height: 120px;
	border: 2px solid #ddd;
	border-radius: 50%;
	overflow: hidden;
}

.photo {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.form-group input, .form-group select {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-sizing: border-box;
}

.form-group input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
}

#photo-preview {
	width: 120px;
	height: 120px;
	border-radius: 50%;
	object-fit: cover;
}

#camera-button {
	padding: 8px;
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
}

.photo-container {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="company-info">
				<h2 align="center">Registeration Form</h2>
				<p align="center">
					A-101, First Floor, Above A-20, Sakinaka Industrial Market,<br>
					Beside Holiday Inn Hotel Ghatkopar-Andheri Link Road,<br>
					Sakinaka, Andheri(E), Mumbai-400072<br>

				</p>
			</div>

			<div class="photo-container">

				<div class="photo-frame">

					<canvas id="photo-canvas" style="display: none;"></canvas>
					<img id="photo-preview" alt="Profile Photo"> <input
						type="hidden" id="photo-canvas" name="photoData">
				

				</div>
<div>
 <h1><input type="file" name="photo" size="50"/></h1>

</div>
				<div>

					<input type="button" value="Take Photo" id="camera-button">

				</div>

			</div>

		</div>

		<form action="register" method="post" enctype="multipart/form-data">

			<table>
				<tr>
			<!--  		<th>Form no :<input type="text" name="form"></th>-->
					<th><h3 align="left">Registration Form</h3></th>
					<th>Date :<input type="date" name="date"></th>
				</tr>
			</table>

			<table>
				<tr>
					<th><label for="applicantName">Applicant Name:</label></th>
					<td><input type="text" id="applicantName" name="applicantName"
						required></td>
				</tr>
				<tr>
					<th><label for="address">Residential Address:</label></th>
					<td><textarea id="address" name="address" required></textarea></td>
				</tr>
				<tr>
					<th><label for="gender">Gender:</label></th>
					<td><select id="gender" name="gender" required>
							<option value="">Select gender</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
					</select></td>
				</tr>
				<tr>
					<th><label for="maritalStatus">Marital Status:</label></th>
					<td><select id="maritalStatus" name="maritalStatus" required>
							<option value="">Select marital status</option>
							<option value="Single">Single</option>
							<option value="Married">Married</option>
							<option value="Divorced">Divorced</option>
							<option value="Widowed">Widowed</option>
					</select></td>
				</tr>
				<tr>
					<th><label for="dob">Date of Birth:</label></th>
					<td><input type="date" id="dob" name="dob" required></td>
				</tr>
				<tr>
					<th><label for="pan">Identity Proof (PAN):</label></th>
					<td><input type="text" id="pan" name="pan" required></td>
				</tr>
				<tr>
					<th><label for="aadhar">Address Proof (Aadhar No):</label></th>
					<td><input type="text" id="aadhar" name="aadhar" required></td>
				</tr>
				<tr>
					<th><label for="email">Email Id:</label></th>
					<td><input type="email" id="email" name="email" required></td>
				</tr>
				<tr>
					<th><label for="contact">Contact No:</label></th>
					<td><input type="tel" id="contact" name="contact" required></td>
				</tr>
				
				
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- <script>
    const cameraButton = document.getElementById('camera-button');
    const photoCanvas = document.getElementById('photo-canvas');
    const photoPreview = document.getElementById('photo-preview');
    const photoDataInput = document.getElementById('photo-data');
    
    const qualification = document.querySelectorAll('input[name=qualification]')
    const qualifyInputs = document.querySelectorAll('.qualification')
    const table = document.querySelector('table')
    qualification.forEach(btn =>{
    	
    	btn.oninput = ()=>{
    		
    		if(btn.checked && btn.value == 'graduate'){
    			
    			qualification.forEach(row =>{
    				
    				if(!row.classList.contains('graduate')){
    					
    					table.removeChild(row)
    					
    				}
    				
    			})
    			
    		}else if(btn.checked && btn.value == 'undergraduate'){
    			
qualification.forEach(row =>{
    				
    				if(!row.classList.contains('undergraduate')){
    					
    					table.removeChild(row)
    					
    				}
    				
    			})
    			
    		}else if(btn.checked && btn.value == 'backlog'){
    			
qualification.forEach(row =>{
    				
    				if(!row.classList.contains('backlog')){
    					
    					table.removeChild(row)
    					
    				}
    				
    			})
    			
    		}
    		
    	}
    	
    })

    cameraButton.addEventListener('click', () => {
      if ('mediaDevices' in navigator && 'getUserMedia' in navigator.mediaDevices) {
        navigator.mediaDevices.getUserMedia({ video: true })
          .then((stream) => {
            const video = document.createElement('video');
            video.srcObject = stream;
            video.autoplay = true;

            video.addEventListener('loadedmetadata', () => {
              photoCanvas.width = video.videoWidth;
              photoCanvas.height = video.videoHeight;
              photoCanvas.getContext('2d').drawImage(video, 0, 0, video.videoWidth, video.videoHeight);

              const photoData = photoCanvas.toDataURL();
              photoPreview.src = photoData;
              photoDataInput.value = photoData;

              video.srcObject.getTracks().forEach((track) => {
                track.stop();
              });
            });
          })
          .catch((error) => {
            console.error('Error accessing camera:', error);
          });
      } else {
        console.error('Camera access not supported.');
      }
    });
  </script>
 -->
</body>
</html>