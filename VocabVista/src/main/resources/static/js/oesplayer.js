$(document).ready(function(){
	$('div[id^=MMplayer_]').each(function(e){
		$(this).attr('data-ready',false);
		$(this).data('ready',false);
		if($(this).data('medialoadonready'))
		{
			initPlayer($(this));
			$(this).attr('data-ready',true);
			$(this).data('ready',true);
			$(this).bind('destroy', function(event) { 
				destroy($(this));
			});
		}		
		else
		{			
			$(this).bind('initPlayer', function(event) { 
				if(!$(this).data('ready'))
				{
					initPlayer($(this),event);
					$(this).attr('data-ready',true);
					$(this).data('ready',true);
				}
			});
			$(this).bind('destroy', function(event) { 
				destroy($(this));
			});
		}
	});	
});
function initPlayer(player,event)
{				
	if($(player).data('mediatype')=='audio')
	{		
		if($(player).data('mediamode')=='exam')
		{			
			$(player).html('<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer"></div><div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-audio exam playerdiv" role="application" aria-label="media player">	<div class="jp-type-single">		<div class="jp-gui jp-interface">			<div class="jp-controls">				<button class="jp-play" role="button" tabindex="0">					play				</button>			</div>			<div class="jp-progress">					<div class="jp-play-bar">					</div>			</div>			<div class="jp-time-holder">				<div class="jp-current-time" role="timer" aria-label="time">				&nbsp;</div>				<div class="jp-duration" role="timer" aria-label="duration">				&nbsp;</div>			</div>		</div>		<div class="jp-details">			<div class="jp-title" aria-label="title">			&nbsp;</div>		</div>		<div class="jp-no-solution">			<span>Update Required</span>			To play the media you will need to either update your browser to a recent version or update your Flash plugin.		</div>	</div></div>');
		}
		else if($(player).data('mediamode')=='open')
		{
			$(player).html('<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer"></div><div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-audio open playerdiv" role="application" aria-label="media player">	<div class="jp-type-single">		<div class="jp-gui jp-interface">			<div class="jp-controls">				<button class="jp-play" role="button" tabindex="0">					play				</button>				<button class="jp-stop" role="button" tabindex="0">					stop				</button>			</div>			<div class="jp-progress">				<div class="jp-play-bar"></div>				</div>			<div class="jp-volume-controls">				<button class="jp-volume-max" role="button" tabindex="0">					max volume				</button>				<div class="jp-volume-bar">					<div class="jp-volume-bar-value"></div>				</div>			</div>			<div class="jp-time-holder">				<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>				<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>							</div>		</div>		<div class="jp-details">			<div class="jp-title" aria-label="title">&nbsp;</div>		</div>		<div class="jp-no-solution">			<span>Update Required</span>			To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.		</div>	</div></div>');
		}	
		else if($(player).data('mediamode')=='success')
		{
			$(player).html('<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer clearfix"></div> <div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-audio clearfix" role="application" aria-label="      media player"> <div class="jp-type-single"> <div class="jp-gui jp-interface"> <div class="jp-controls"> <button class="jp-play" role="button" tabindex="0">play</button> </div> <div class="jp-progress"> <div class="jp-play-bar"> <div class="playhead"></div> </div> </div>  </div> <div class="jp-no-solution"> <span>Update Required</span> To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>. </div> </div> </div>');
		}
		$(player).find('#oes_'+$(player).attr('id')).jPlayer({
		ready: function (event) {
			if($(player).data('mediaext')=="mp3")
			{
				$(this).jPlayer("setMedia", {
					mp3: $(player).data('mediaurl')					
				});				
			}
			else if($(player).data('mediaext')=="m4a")
			{
				$(this).jPlayer("setMedia", {
					m4a: $(player).data('mediaurl')
				});
			}
			else if($(player).data('mediaext')=="ogg")
			{
				$(this).jPlayer("setMedia", {
					ogg: $(player).data('mediaurl')
				});
			}
			else if($(player).data('mediaext')=="oga")
			{
				$(this).jPlayer("setMedia", {
					oga: $(player).data('mediaurl')
				});
			}
			else if($(player).data('mediaext')=="webma")
			{
				$(this).jPlayer("setMedia", {
					webma: $(player).data('mediaurl')
				});
			}
			else if($(player).data('mediaext')=="wav")
			{
				$(this).jPlayer("setMedia", {
					wav: $(player).data('mediaurl')
				});
			}
		},
		swfPath: "../resources/js/jplayer.swf",
		supplied: $(player).data('mediaext'),
		wmode: "transparent",
		cssSelectorAncestor: "#jp_container_" + $(player).attr('id').replace('MMplayer_',''),
		useStateClassSkin: true,
		autoBlur: true,
		smoothPlayBar: true,
		keyEnabled: false,
		solution: "html, flash",
		volume: 1,
		errorAlerts:true,
		play:  (event && event.play) ? event.play : play,
		pause: (event && event.pause) ? event.pause : function(){},
		ended: (event && event.end) ? event.end : end
		});			
		if($(player).data('mediatitle') && $(player).data('mediatitle')!='')
		{
			$(player).find('.playerdiv').find($(player).find('#oes_'+$(player).attr('id')).jPlayer("option", "cssSelector.title")).html($(player).data('mediatitle'));
		}
	}
	else if($(player).data('mediatype')=='video')
	{
		if($(player).data('mediamode')=='exam')
		{	
			$(player).html('<div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-video exam playerdiv" role="application" aria-label="media player">	<div class="jp-type-single">		<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer"></div>		<div class="jp-gui">						<div class="jp-interface">				<div class="jp-controls">					<button class="jp-play" role="button" tabindex="0">play</button>				</div>									<div class="jp-toggles">					<button class="jp-full-screen" role="button" tabindex="0">full screen</button>				</div>				<div class="jp-progress">										<div class="jp-play-bar"></div>									</div>				<div class="jp-time-holder">				<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>				<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>				</div>			</div></div>			<div class="jp-details">				<div class="jp-title" aria-label="title">&nbsp;</div>			</div>							<div class="jp-no-solution">			<span>Update Required</span>			To play the media you will need to either update your browser to a recent version or update your Flash plugin.		</div>	</div></div>');
		}
		else if($(player).data('mediamode')=='open')
		{
			$(player).html('<div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-video open playerdiv" role="application" aria-label="media player">	<div class="jp-type-single">		<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer"></div>		<div class="jp-gui">						<div class="jp-interface">				<div class="jp-progress">					<div class="jp-play-bar"></div>					</div>				<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>				<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>				<div class="jp-controls-holder">					<div class="jp-controls">						<button class="jp-play" role="button" tabindex="0">play</button>						<button class="jp-stop" role="button" tabindex="0">stop</button>					</div>					<div class="jp-volume-controls">						<button class="jp-mute" role="button" tabindex="0">mute</button>						<button class="jp-volume-max" role="button" tabindex="0">max volume</button>						<div class="jp-volume-bar">							<div class="jp-volume-bar-value"></div>						</div>					</div>					<div class="jp-toggles">												<button class="jp-full-screen" role="button" tabindex="0">full screen</button>					</div>				</div>				<div class="jp-details">					<div class="jp-title" aria-label="title">&nbsp;</div>				</div>			</div>		</div>		<div class="jp-no-solution">			<span>Update Required</span>			To play the media you will need to either update your browser to a recent version or update your Flash plugin.		</div>	</div></div>');
		}
		else if($(player).data('mediamode')=='success')
		{			
			$(player).html('<div id="jp_container_'+$(player).attr('id').replace('MMplayer_','')+'" class="jp-video jp-video-360p" role="application" aria-label="media player"> 	<div class="jp-type-single"> 		<div id="oes_'+$(player).attr('id')+'" class="jp-jplayer"></div> 		<div class="jp-gui"> 						<div class="jp-interface"> 				<div class="jp-progress"> 					<div class="jp-play-bar"> <div class="playhead"></div> </div> </div> <div class="jp-controls-holder"> <div class="jp-controls"> <button class="ic-timeline jp-play" role="button" tabindex="0">play</button> </div> <div class="jp-toggles">  <button class="jp-full-screen" role="button" tabindex="0">full screen</button> </div> </div>  </div> </div> <div class="jp-no-solution"> <span>Update Required</span> To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>. </div> </div> </div>');
		}
		var support = $(player).data('mediaext');
		if(support=="mp4")
		{
			support = "m4v";				
		}
		$(player).find('#oes_'+$(player).attr('id')).jPlayer({
		ready: function (event) {
			if(support=="m4v")
			{					
				$(this).jPlayer("setMedia", {
					m4v: $(player).data('mediaurl')
				});					
			}				
		},
		swfPath: "../resources/js/jplayer.swf",
		supplied: support,
		wmode: "transparent",		
		cssSelectorAncestor: "#jp_container_" + $(player).attr('id').replace('MMplayer_',''),
		useStateClassSkin: true,
		autoBlur: true,
		smoothPlayBar: true,
		keyEnabled: false,
		solution: "html, flash",
		errorAlerts:true,		
		play:  (event && event.play) ? event.play : play,
		pause: (event && event.pause) ? event.pause : function(){},
		ended: (event && event.end) ? event.end : end	
		});
		if($(player).data('mediamode')=='success')
		{
			$(player).find('#oes_'+$(player).attr('id')).jPlayer({
				size: { width: "220px",  height: "160px" }
			});
		}
		if($(player).data('mediatitle') && $(player).data('mediatitle')!='')
		{
			$(player).find('.playerdiv').find($(player).find('#oes_'+$(player).attr('id')).jPlayer("option", "cssSelector.title")).html($(player).data('mediatitle'));
		}
	}
}
function play()
{
	$(this).jPlayer("pauseOthers", 0);	
	if($(this).parents('div[id^=MMplayer_]').data('mediamode')=='success' && $(this).parents('div[id^=MMplayer_]').data('mediatype')=='video')
	{		
		$(this).jPlayer({autohide : { restored : true }});
	}	
}
function end()
{
	$(this).jPlayer("destroy");	
	initPlayer($(this).parents('div[id^=MMplayer_]'));
}
function destroy(player)
{
	if($(player).data('mediatype')=='audio')
	{
		$('#' + 'oes_' + $(player).attr('id')).jPlayer("destroy");	
		$('#' + 'oes_' + $(player).attr('id')).remove();
	}
	if($(player).data('mediatype')=='video')
	{
		$('#' + 'jp_container_' + $(player).attr('id').replace('MMplayer_','')).jPlayer("destroy");	
		$('#' + 'jp_container_' + $(player).attr('id').replace('MMplayer_','')).remove();
	}
	$(player).data('ready',false);
	$(this).attr('data-ready',false);		
}