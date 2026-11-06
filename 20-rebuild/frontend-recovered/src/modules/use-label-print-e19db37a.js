import { $ as u } from "../shared/runtime.js";
import { ref as $ } from "vue";
import { ElLoading as x } from "element-plus";
import { ElNotification as E } from "element-plus";
function C({ getPrintTotalNumber: f, getLabelInfo: m, getLoadingTextFunc: p, printLabelFunc: y, needAddPrintRecord: b = false, addPrintIdField: a = "id", addPrintRecordReq: i, batchPrintSuccessHook: v, printFinallyHook: h }) {
  const s = $();
  async function w(t, o = null, e = null) {
    a = o || a, i = e || i;
    try {
      await g(t, a, i), typeof batchPrintHook == "function" && v();
    } catch (l) {
      console.log("批量打印错误", l);
    }
  }
  async function g(t, o = null, e = null) {
    a = o || a, i = e || i, s.value = x.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      for (const l of t) console.log(l), await L(l);
      s.value.text = "已全部加入打印队列", await u(500);
    } catch (l) {
      throw E({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(l);
    } finally {
      s.value.close(), typeof h == "function" && h();
    }
  }
  async function L(t) {
    var c;
    console.log(f(t), "printTotalNumber");
    let o = f(t), e = 0;
    const l = (/* @__PURE__ */ new Date()).getTime();
    try {
      if (t.boolOneCode) for (o = ((c = t.numberList) == null ? void 0 : c.length) || 0; o--; ) {
        const n = t.numberList[e];
        s.value.text = `正在加入打印队列：${p(t)}，当前一物一码编号：${n}`, await u(500);
        const r = await m(t, n);
        await y(r), e++;
      }
      else {
        const n = await m(t);
        for (; o--; ) s.value.text = `正在加入打印队列：${p(t)} 第${e + 1}张`, await u(500), await y(n), e++;
      }
    } catch (n) {
      throw console.log("打印标签时发生错误", n), new Error(n);
    } finally {
      const n = (/* @__PURE__ */ new Date()).getTime();
      b && (console.log(t, t[a], a), T(t, { id: t[a], quantity: e, startTime: l, endTime: n, numberList: t.numberList }));
    }
  }
  async function T(t, { id: o, quantity: e, startTime: l, endTime: c, numberList: n }) {
    if (!(!o || !e)) try {
      console.log("添加打印记录"), await i({ id: o, quantity: e, startTime: l, endTime: c, numberList: n }), t.printedQuantity += e;
    } catch (r) {
      console.log("添加打印记录失败", r);
    }
  }
  return { batchPrint: w, print: g };
}
export {
  C as u
};
