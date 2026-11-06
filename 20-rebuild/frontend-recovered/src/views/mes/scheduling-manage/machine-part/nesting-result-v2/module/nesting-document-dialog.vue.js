import { ref as f } from "vue";
import { inject as A } from "vue";
import { ElNotification as b } from "element-plus";
import { resolveComponent as y } from "vue";
import { openBlock as c } from "vue";
import { createBlock as w } from "vue";
import { withCtx as u } from "vue";
import { unref as r } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as S } from "vue";
import { createVNode as _ } from "vue";
import { withDirectives as T } from "vue";
import { createElementBlock as L } from "vue";
import { normalizeStyle as q } from "vue";
import { isRef as G } from "vue";
import { vLoading as J } from "element-plus";
import { _ as M, u as X, o as Z, re as k, qX as h, G as K, a6 as Q, rn as W, ro as Y } from "../../../../../../shared/runtime.js";
import { p as ee } from "../../../../../../modules/print-e379c493.js";
const te = { key: 1, class: "tip" }, oe = { __name: "nesting-document-dialog", props: { visible: { type: Boolean, default: false }, nestingList: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(m, { emit: D }) {
  const C = "/assets";
  f([]);
  const R = A("permission"), j = D, i = m, g = f(false), l = f(""), d = f(false), { visible: p, handleClose: I } = X({ emit: j, props: i, field: "visible", showHook: P, closeHook: B }), { maxHeight: x } = Z({ navbar: false }, p);
  function P() {
    F();
  }
  function B() {
    l.value = "";
  }
  async function F() {
    try {
      g.value = true, l.value = "";
      const t = await k({ jobId: i.nestingList.jobId, nestingResultIdList: i.nestingList.id ? [i.nestingList.id] : [] }), e = t.headers.result && decodeURIComponent(t.headers.result).split(";");
      if (e) {
        const n = e[0].split("=")[1], o = e[1].split("=")[1], a = h(t) || "";
        n === "20000" ? l.value = await U(t) : b.error({ title: `${a}获取套料任务单失败`, message: `${o}` });
      } else b.error("获取套料任务单失败");
    } catch (t) {
      console.log("获取套料任务单失败", t);
    } finally {
      g.value = false;
    }
  }
  function U(t) {
    return new Promise((e, n) => {
      if (t && t.data && t.data.size) {
        const o = t.data, a = new window.FileReader();
        a.readAsArrayBuffer(o), a.onload = function(s) {
          const N = s.target.result, O = o.type, H = new Blob([N], { type: O }), $ = window.URL.createObjectURL(H);
          e($);
        };
      } else n();
    });
  }
  const z = () => {
    ee({ printable: l.value, onPrintDialogClose: () => {
      b({ title: "打印PDF成功", type: "success", duration: 2500 });
    }, onError: () => {
      throw new Error("PDF加载失败");
    } });
  }, V = async (t) => {
    d.value = true;
    try {
      const e = await k({ jobId: i.nestingList.jobId, nestingResultIdList: i.nestingList.id ? [i.nestingList.id] : [] }), n = window.URL.createObjectURL(new Blob([e.data], { type: "application/pdf" })), o = document.createElement("a");
      o.href = n, o.setAttribute("download", "报告单.pdf"), document.body.appendChild(o), o.click(), o.remove();
    } catch (e) {
      console.log("下载附件", e);
    } finally {
      d.value = false;
    }
  };
  async function E(t) {
    d.value = true;
    try {
      const e = { jobId: t.jobId, nestingResultId: t.id }, n = await W(e);
      if (h(n)) {
        const a = window.URL.createObjectURL(new Blob([n.data], { type: "application/zip" })), s = document.createElement("a");
        s.href = a, s.setAttribute("download", "数控切割文件.zip"), document.body.appendChild(s), s.click(), s.remove();
      } else await Y(e);
    } catch (e) {
      console.log("下载代码附件", e);
    } finally {
      d.value = false;
    }
  }
  return (t, e) => {
    const n = y("common-button"), o = y("common-drawer"), a = J;
    return c(), w(o, { title: "套料报告", customClass: "nesting-document-dialog", modelValue: r(p), "onUpdate:modelValue": e[2] || (e[2] = (s) => G(p) ? p.value = s : null), "close-on-click-modal": false, size: "45%", showClose: true, "before-close": r(I), destroyOnClose: "" }, { titleRight: u(() => [r(K)(r(R).downloadZip) ? (c(), w(n, { key: 0, type: "success", size: "default", loading: d.value, onClick: e[0] || (e[0] = (s) => V(m.nestingList)) }, { default: u(() => e[3] || (e[3] = [v("下载")])), _: 1, __: [3] }, 8, ["loading"])) : S("", true), _(n, { type: "warning", size: "default", onClick: z }, { default: u(() => e[4] || (e[4] = [v("打印")])), _: 1, __: [4] })]), content: u(() => [_(n, { type: "primary", loading: d.value, size: "default", onClick: e[1] || (e[1] = (s) => E(m.nestingList)), icon: "el-icon-download", style: { "margin-bottom": "10px" }, disabled: !m.nestingList.machineToolId }, { default: u(() => e[5] || (e[5] = [v(" 切割代码下载 ")])), _: 1, __: [5] }, 8, ["loading", "disabled"]), T((c(), L("div", { style: q(`height:${r(x)}px; overflow: auto`) }, [l.value ? (c(), w(r(Q), { key: 0, url: l.value, type: "canvas", pdfjsDistPath: C }, null, 8, ["url"])) : (c(), L("div", te, "*获取套料任务单失败"))], 4)), [[a, g.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ie = M(oe, [["__scopeId", "data-v-7bf32042"]]);
export {
  ie as default
};
