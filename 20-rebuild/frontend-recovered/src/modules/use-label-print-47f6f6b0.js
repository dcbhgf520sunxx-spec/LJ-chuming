import { $ as s } from "../shared/runtime.js";
import { ref as T } from "vue";
import { ElLoading as $ } from "element-plus";
import { ElNotification as x } from "element-plus";
function k({ getPrintTotalNumber: f, getLabelInfo: u, getLoadingTextFunc: m, printLabelFunc: p, needAddPrintRecord: h = false, addPrintIdField: l = "id", addPrintRecordReq: b, batchPrintSuccessHook: v, printFinallyHook: y }) {
  const a = T();
  async function d(t) {
    try {
      await g(t), typeof batchPrintHook == "function" && v();
    } catch (e) {
      console.log("批量打印错误", e);
    }
  }
  async function g(t) {
    console.log(t), a.value = $.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      for (const e of t) console.log(e), await w(e);
      a.value.text = "已全部加入打印队列", await s(500);
    } catch (e) {
      throw x({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(e);
    } finally {
      a.value.close(), typeof y == "function" && y();
    }
  }
  async function w(t) {
    var i;
    console.log(f(t), "printTotalNumber");
    let e = f(t), o = 0;
    const c = (/* @__PURE__ */ new Date()).getTime();
    try {
      if (t.boolOneCode) for (e = ((i = t.numberList) == null ? void 0 : i.length) || 0; e--; ) {
        const n = t.numberList[o];
        a.value.text = `正在加入打印队列：${m(t)}，当前一物一码编号：${n}`, await s(500);
        const r = await u(t, n);
        await p(r), o++;
      }
      else {
        const n = await u(t);
        for (; e--; ) a.value.text = `正在加入打印队列：${m(t)} 第${o + 1}张`, await s(500), await p(n), o++;
      }
    } catch (n) {
      throw console.log("打印标签时发生错误", n), new Error(n);
    } finally {
      const n = (/* @__PURE__ */ new Date()).getTime();
      h && (console.log(t, t[l], l), L(t, { id: t[l], quantity: o, startTime: c, endTime: n, numberList: t.numberList }));
    }
  }
  async function L(t, { id: e, quantity: o, startTime: c, endTime: i, numberList: n }) {
    if (!(!e || !o)) try {
      console.log("添加打印记录"), await b({ id: e, quantity: o, startTime: c, endTime: i, numberList: n }), t.printedQuantity += o;
    } catch (r) {
      console.log("添加打印记录失败", r);
    }
  }
  return { batchPrint: d, print: g };
}
export {
  k as u
};
