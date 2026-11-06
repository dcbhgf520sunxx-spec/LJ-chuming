import { sf as c, ci as f } from "../shared/runtime.js";
async function r(t) {
  let a;
  try {
    const { content: e = [] } = await c(t);
    e.forEach((o) => {
      o.isDefault && o.config && (a = JSON.parse(o.config));
    });
  } catch (e) {
    console.log("表格模板", e);
  }
  return a || f[t];
}
export {
  r as u
};
