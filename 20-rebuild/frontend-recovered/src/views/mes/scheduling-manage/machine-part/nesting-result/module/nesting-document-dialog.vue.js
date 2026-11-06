import { ref as m } from "vue";
import { inject as O } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as g } from "vue";
import { createBlock as b } from "vue";
import { withCtx as d } from "vue";
import { unref as i } from "vue";
import { createTextVNode as y } from "vue";
import { createCommentVNode as H } from "vue";
import { createVNode as v } from "vue";
import { withDirectives as N } from "vue";
import { createElementBlock as A } from "vue";
import { normalizeStyle as S } from "vue";
import { isRef as $ } from "vue";
import { ElNotification as q } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as J, u as M, o as X, rx as _, G as Z, a6 as K, ry as Q, qX as W, ro as Y } from "../../../../../../shared/runtime.js";
import { p as ee } from "../../../../../../modules/print-e379c493.js";
const te = { __name: "nesting-document-dialog", props: { visible: { type: Boolean, default: false }, nestingList: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(r, { emit: h }) {
  const k = "/assets";
  m([]);
  const x = O("permission"), L = h, p = r, f = m(false), c = m(""), s = m(false), { visible: u, handleClose: D } = M({ emit: L, props: p, field: "visible", showHook: C, closeHook: j }), { maxHeight: I } = X({ navbar: false }, u);
  function C() {
    P();
  }
  function j() {
    c.value = "";
  }
  async function P() {
    try {
      f.value = true, c.value = "";
      const t = await _({ resultId: p.nestingList.guid, machineToolId: p.nestingList.machineToolId });
      c.value = await R(t);
    } catch (t) {
      console.log("获取套料任务单失败", t);
    } finally {
      f.value = false;
    }
  }
  function R(t) {
    return new Promise((e, a) => {
      if (t && t.data && t.data.size) {
        const o = t.data, l = new window.FileReader();
        l.readAsArrayBuffer(o), l.onload = function(n) {
          const T = n.target.result, z = o.type, U = new Blob([T], { type: z }), V = window.URL.createObjectURL(U);
          e(V);
        };
      } else a();
    });
  }
  const B = () => {
    ee({ printable: c.value, onPrintDialogClose: () => {
      q({ title: "打印PDF成功", type: "success", duration: 2500 });
    }, onError: () => {
      throw new Error("PDF加载失败");
    } });
  }, E = async (t) => {
    s.value = true;
    try {
      const e = await _({ resultId: t.guid, machineToolId: t.machineToolId }), a = window.URL.createObjectURL(new Blob([e.data], { type: "application/pdf" })), o = document.createElement("a");
      o.href = a, o.setAttribute("download", "报告单.pdf"), document.body.appendChild(o), o.click(), o.remove();
    } catch (e) {
      console.log("下载附件", e);
    } finally {
      s.value = false;
    }
  };
  async function F(t) {
    s.value = true;
    try {
      const e = { resultList: [t.guid], jobId: t.jobId, nameFilterFlag: false, machineToolId: t.machineToolId }, a = await Q(e);
      if (W(a)) {
        const l = window.URL.createObjectURL(new Blob([a.data], { type: "application/zip" })), n = document.createElement("a");
        n.href = l, n.setAttribute("download", "数控切割文件.zip"), document.body.appendChild(n), n.click(), n.remove();
      } else await Y(e);
    } catch (e) {
      console.log("下载代码附件", e);
    } finally {
      s.value = false;
    }
  }
  return (t, e) => {
    const a = w("common-button"), o = w("common-drawer"), l = G;
    return g(), b(o, { title: "套料报告", customClass: "nesting-document-dialog", modelValue: i(u), "onUpdate:modelValue": e[2] || (e[2] = (n) => $(u) ? u.value = n : null), "close-on-click-modal": false, size: "45%", showClose: true, "before-close": i(D), destroyOnClose: "" }, { titleRight: d(() => [i(Z)(i(x).downloadZip) ? (g(), b(a, { key: 0, type: "success", size: "default", loading: s.value, onClick: e[0] || (e[0] = (n) => E(r.nestingList)) }, { default: d(() => e[3] || (e[3] = [y("下载")])), _: 1, __: [3] }, 8, ["loading"])) : H("", true), v(a, { type: "warning", size: "default", onClick: B }, { default: d(() => e[4] || (e[4] = [y("打印")])), _: 1, __: [4] })]), content: d(() => [v(a, { type: "primary", loading: s.value, size: "default", onClick: e[1] || (e[1] = (n) => F(r.nestingList)), icon: "el-icon-download", style: { "margin-bottom": "10px" }, disabled: !r.nestingList.machineToolId }, { default: d(() => e[5] || (e[5] = [y(" 切割代码下载 ")])), _: 1, __: [5] }, 8, ["loading", "disabled"]), N((g(), A("div", { style: S(`height:${i(I)}px; overflow: auto`) }, [v(i(K), { url: c.value, type: "canvas", pdfjsDistPath: k }, null, 8, ["url"])], 4)), [[l, f.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, se = J(te, [["__scopeId", "data-v-42697524"]]);
export {
  se as default
};
