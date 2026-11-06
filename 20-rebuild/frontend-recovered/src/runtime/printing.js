export function hasConfiguredPrinter(environment=globalThis) {
  return typeof environment.LJAPS_PRINT_ADAPTER?.getPrinter === 'function';
}

/** Keep report markup isolated from the application session. */
export function showReportPreview({ title, html }, document=globalThis.document) {
  const dialog=document.createElement('dialog');
  dialog.setAttribute('aria-label', '打印预览');
  dialog.style.cssText='width:min(96vw,1200px);max-width:96vw;padding:12px;border:1px solid #bbb;border-radius:6px';

  const toolbar=document.createElement('header');
  toolbar.style.cssText='display:flex;align-items:center;justify-content:space-between;margin-bottom:10px';
  const heading=document.createElement('strong');
  heading.textContent=title || '打印预览';
  const close=document.createElement('button');
  close.type='button';
  close.textContent='关闭预览';
  close.addEventListener('click', () => dialog.close());
  toolbar.append(heading, close);

  const frame=document.createElement('iframe');
  frame.title='报表内容';
  frame.setAttribute('sandbox', '');
  frame.style.cssText='display:block;width:100%;height:78vh;border:1px solid #ddd;background:white';
  const origin=document.location.origin;
  frame.srcdoc=`<!doctype html><meta charset="utf-8">
    <meta http-equiv="Content-Security-Policy" content="default-src 'none'; img-src ${origin} data:; style-src 'unsafe-inline'; base-uri 'none'; form-action 'none'">
    <style>body{margin:16px;font:14px sans-serif}table{max-width:100%}</style>
    ${html}`;

  dialog.append(toolbar, frame);
  document.body.append(dialog);
  return new Promise(resolve => {
    dialog.addEventListener('close', () => {
      dialog.remove();
      resolve('previewed');
    }, { once:true });
    dialog.showModal();
  });
}

/** Explicit integration point. Importing this module performs no device or network probing. */
export async function getConfiguredPrinter(environment=globalThis) {
  const adapter=environment.LJAPS_PRINT_ADAPTER;
  if(!adapter || typeof adapter.getPrinter!=='function') {
    throw new Error('打印未配置：请先配置本地打印适配器后再打印。');
  }
  const printer=await adapter.getPrinter();
  if(!printer || typeof printer.PRINT_INIT!=='function' || typeof printer.SET_PRINT_MODE!=='function') {
    throw new Error('本地打印适配器不可用，请检查设备连接与适配器配置。');
  }
  return printer;
}

/** A driver rejection must never become the recovered client's unconditional `true`. */
export function requirePrintResult(result, operation='打印') {
  if(result===false) throw new Error(`本地打印操作失败（${operation}）：驱动未接受请求，请检查设备状态。`);
  return result;
}
