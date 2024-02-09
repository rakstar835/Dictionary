<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Video</title>



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	
	<link rel="stylesheet" href="<c:url value='/resources/css/template.css'></c:url>" type="text/css" />
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<script src="<c:url value='/resources/js/jquery.jplayer.min.js'></c:url>"></script>
<script src="<c:url value='/resources/js/oesplayer.js?${jsTime }'></c:url>"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
	
<script type="text/javascript">
	function playaudio() {
		$('#MMplayer_1').jPlayer("play");
	}

</script>
<style type="text/css">

.video-container {
    position: relative;
    max-width: 640px;
    margin: 0 auto;
    /* display: flex;  *//* Use flex layout to align the video and timeline side by side */
    flex-wrap: wrap; /* Allow items to wrap to the next line if needed */
    justify-content: space-between; /* Create space between the video and timeline */
    align-items: flex-start; /* Align the video and timeline to the top */
}

#videoPlayer {
    width: calc(70% - 10px); /* Adjust the video width and leave some space */
    height: auto;
}

.timeline {
    width: calc(30% - 10px); /* Adjust the timeline width and leave some space */
    background-color: #eee;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 10px 0;
}

.timeline-strip {
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-bottom: 10px;
}

.strip-text {
    font-weight: bold;
    margin-right: 5px;
}

.timeline-dot {
    width: 10px;
    height: 10px;
    background-color: #007bff;
    border-radius: 50%;
    cursor: pointer;
    margin-right: 5px;
}

/* Add more styles as needed */



</style>
</head>
<body class="exampage exampage-hgt">



	<div class="container">
		<h1 class="mt-5">Simple Video Page</h1>

<div class="video-container">
        <video id="videoPlayer" controls width="640" height="360" class="mt-3">
            <source src="<c:url value="/resources/videos/Time_Tracker.mp4"></c:url>" type="video/mp4">
        </video>
       
        <div class="timeline">
            <div class="timeline-strip">
                <div class="strip-text">Category 1:</div>
                <!-- Add time range and dots for Category 1 here -->
            </div>
            <div class="timeline-strip">
                <div class="strip-text">Category 2:</div>
                <!-- Add time range and dots for Category 2 here -->
            </div>
            <div class="timeline-strip">
                <div class="strip-text">Category 3:</div>
                <!-- Add time range and dots for Category 3 here -->
            </div>
        </div>
    </div>

		<!-- <div class="left-holder">
			<div class="comprehension scrollbar-outer">
				<div class="qVideo-holder">
					
					<div id="MMplayer_1" data-mediamode="exam" data-mediatype="video"
						data-mediaurl="/resources/videos/Time_Tracker.mp4&e=mp4"
						data-mediaext="mp4" data-medialoadonready="true"
						data-mediatitle=""></div>
						
				</div>
			</div>
		</div> -->
		
	</div>
	
	 <script>
      
        document.addEventListener('DOMContentLoaded', function () {
            const videoPlayer = document.getElementById('videoPlayer');
            const timeline = document.querySelector('.timeline');

            // Define chapters for Category 1 with time stamps and descriptions
            const category1Chapters = [
                { time: 0, description: 'LogWork introduction' },
                { time: 16, description: 'How to create an account on LogWork' },
                { time: 42, description: 'Dashboard introduction' },
                { time: 191, description: 'How to invite teammates to your workspace' },
                // Add more chapters for Category 1
            ];

            // Define chapters for Category 2
            const category2Chapters = [
                { time: 61, description: 'How to check the account settings' },
                { time: 77, description: 'How to set up a workspace for your team' },
                { time: 228, description: 'How to use a time tracker' },
                { time: 393, description: 'PDF and Excel Timesheet reports' },
                // Add more chapters for Category 2
            ];

            // Define chapters for Category 3
            const category3Chapters = [
                { time: 288, description: 'How to monitor productivity in the “Timeline” section' },
                { time: 351, description: 'Time Tracker Software' },
                { time: 369, description: 'Time Tracker Chrome Extension' },
                { time: 481, description: 'How to create a client' },
                { time: 515, description: 'How to manage projects' },
                // Add more chapters for Category 3
            ];
            
            // Create a strip with text and dots for Category 1
            const category1Strip = document.querySelector('.timeline-strip:nth-child(1)');

            category1Chapters.forEach(chapter => {
                const dot = document.createElement('div');
                dot.className = 'timeline-dot';
                dot.title = chapter.description;

                dot.addEventListener('click', () => {
                    videoPlayer.currentTime = chapter.time;
                });

                category1Strip.appendChild(dot);
            });

            // Create a strip with text and dots for Category 2
            const category2Strip = document.querySelector('.timeline-strip:nth-child(2)');

            category2Chapters.forEach(chapter => {
                const dot = document.createElement('div');
                dot.className = 'timeline-dot';
                dot.title = chapter.description;

                dot.addEventListener('click', () => {
                    videoPlayer.currentTime = chapter.time;
                });

                category2Strip.appendChild(dot);
            });

            // Create a strip with text and dots for Category 3
            const category3Strip = document.querySelector('.timeline-strip:nth-child(3)');

            category3Chapters.forEach(chapter => {
                const dot = document.createElement('div');
                dot.className = 'timeline-dot';
                dot.title = chapter.description;

                dot.addEventListener('click', () => {
                    videoPlayer.currentTime = chapter.time;
                });

                category3Strip.appendChild(dot);
            });

            // Update the dots' positions as the video plays (similar to previous code)
            videoPlayer.addEventListener('timeupdate', () => {
                const currentTime = videoPlayer.currentTime;
                const videoDuration = videoPlayer.duration;

                [category1Chapters, category2Chapters, category3Chapters].forEach((chapters, index) => {
                    chapters.forEach(chapter => {
                        const dot = document.querySelector(`.timeline-strip:nth-child(${index + 1}) .timeline-dot[title="${chapter.description}"]`);
                        if (dot) {
                            const position = (chapter.time / videoDuration) * 100;
                            dot.style.left = `${position}%`;
                        }
                    });
                });
            });
        });


    </script>
</body>	
</html>
