import { ref as w } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as i } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createVNode as g } from "vue";
import { createTextVNode as r } from "vue";
import { unref as d } from "vue";
import { createElementVNode as B } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as V } from "vue";
import { renderList as N } from "vue";
import { toDisplayString as T } from "vue";
import { isRef as E } from "vue";
import { ElMessageBox as I } from "element-plus";
import { ElNotification as L } from "element-plus";
import { ElTag as S } from "element-plus";
import { c as R } from "../../../../../../modules/machine-10301ee2.js";
import { _ as j, u as z } from "../../../../../../shared/runtime.js";
import { a as F } from "../../../../../../modules/project-data-5e9d497a.js";
const M = { class: "flex-rss" }, q = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object }, selectLineId: { type: String, default: "" }, isSingle: { type: Boolean, default: false } }, emits: ["change"], setup(n, { emit: y }) {
  const o = n, m = w([]), l = y, { visible: c, handleClose: f } = z({ emit: l, props: o, field: "visible", showHook: h });
  function h() {
    k();
  }
  async function k() {
    const { content: e } = await F();
    m.value = e;
  }
  function v(e) {
    l("change", e);
  }
  async function x() {
    console.log("detailData", o.detailData);
    try {
      await I.confirm("是否由 '" + o.detailData.machineName + "' 协同？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const e = [o.detailData.id], t = await R({ mac: o.detailData.mac }, e);
      L({ title: "更改状态成功", message: t, type: "success" }), l("endEvent");
    } catch (e) {
      console.log(e);
    }
  }
  return (e, t) => {
    const u = _("common-button"), b = S, C = _("common-dialog");
    return i(), p(C, { title: "机器转产", width: "50%", "show-close": false, "close-on-click-modal": false, modelValue: d(c), "onUpdate:modelValue": t[0] || (t[0] = (a) => E(c) ? c.value = a : null), "before-close": d(f) }, { titleRight: s(() => [g(u, { type: "primary", size: "default", onClick: x }, { default: s(() => t[1] || (t[1] = [r("完 成")])), _: 1, __: [1] }), g(u, { size: "default", onClick: d(f) }, { default: s(() => t[2] || (t[2] = [r("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: s(() => [B("div", M, [(i(true), D(V, null, N(m.value, (a) => (i(), p(b, { effect: n.selectLineId === a.mac ? "light" : "plain", type: n.selectLineId === a.mac ? "success" : "info", class: "elTag", hit: "", onClick: (H) => v(a), key: a.id }, { default: s(() => [r(T(a.machineName), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"]))), 128))])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = j(q, [["__scopeId", "data-v-c4c86f07"]]);
export {
  G as default
};
