/** Recover one authenticated local session without coupling it to optional configuration calls. */
export function createSessionBootstrap({store, loadMenu, installRoutes, token, onOptionalFailure=()=>{}}) {
  let pending=null, completedToken=null;
  return async function ensureSession(route) {
    const current=token();
    if(!current) return {authenticated:false, installed:false};
    if(completedToken===current && store.getters.loadedMenus) return {authenticated:true, installed:false};
    if(pending?.token===current) return pending.promise;
    const task=(async()=>{
      await store.dispatch('user/getInfo');
      const optional=await Promise.allSettled([
        store.dispatch('config/fetchConfigInfo'),
        store.dispatch('config/fetchClosingTimeConfig')
      ]);
      for(const result of optional) if(result.status==='rejected') onOptionalFailure(result.reason);
      // A genuine authentication failure can have cleared the token while optional calls settled.
      if(token()!==current) return {authenticated:false, installed:false};
      const menu=await loadMenu();
      await store.dispatch('permission/generateRoutes',menu);
      const routes=await store.dispatch('permission/setRoutes',route.path);
      installRoutes(routes);
      await store.dispatch('user/updateLoadedMenus');
      completedToken=current;
      return {authenticated:true, installed:true};
    })();
    pending={token:current,promise:task};
    try{return await task;}finally{if(pending?.promise===task)pending=null;}
  };
}
export function isAuthenticationFailure(error) {
  return [40001,40002,40003,40004,40005,40103].includes(Number(error?.code));
}
