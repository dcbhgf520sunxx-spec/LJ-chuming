import { $ as f, z6 as d, zc as w, z1 as g } from "../shared/runtime.js";
import { p as m } from "./wms-material-label-cf4447ff.js";
import { ElNotification as y } from "element-plus";
import { ElLoading as T } from "element-plus";
function N() {
  let i;
  async function c(t = [], e) {
    let r;
    p(), typeof t == "function" ? r = await t() : r = t;
    try {
      for (const o of r) await s(o, e);
      i.setText("已全部加入打印队列"), await f(500);
    } catch (o) {
      throw y({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(o);
    } finally {
      i && i.close();
    }
  }
  async function s(t, e) {
    const r = t.printNumber * e, o = (/* @__PURE__ */ new Date()).getTime();
    try {
      i.setText(`正在加入打印队列：${t.classifyFullName} ${d(t)}　${w(t)}`), await m({ material: t, copies: r });
      const n = (/* @__PURE__ */ new Date()).getTime();
      return await l({ material: t, number: t.printNumber, copies: e, startTime: o, endTime: n }), true;
    } catch (n) {
      throw console.log("打印标签时发生错误", n), new Error(n);
    }
  }
  async function l({ material: t, number: e, copies: r, startTime: o, endTime: n }) {
    const a = t.id;
    if (!(!a || !e)) try {
      await g({ receiptMaterialId: a, number: e, copies: r, startTime: o, endTime: n }), t.printedNumber += e;
    } catch (u) {
      console.log("添加打印记录失败", u);
    }
  }
  function p() {
    i = T.service({ lock: true, text: "正在准备加入打印队列", fullscreen: true, background: "rgba(255, 255, 255, 0.5)" });
  }
  return { print: c };
}
export {
  N as u
};
