import { ref as d } from "vue";
import { inject as v } from "vue";
import { watch as D } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as c } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as y } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as w } from "vue";
import { unref as n } from "vue";
import { withDirectives as H } from "vue";
import { createVNode as g } from "vue";
import { createElementBlock as S } from "vue";
import { Fragment as N } from "vue";
import { renderList as $ } from "vue";
import { isRef as j } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as F } from "element-plus";
import { e as O } from "../../../../../modules/artifact-aa863eec.js";
import { t as U } from "../../../../../modules/common-b3e76e54.js";
import { _ as q, u as z, o as K, na as P } from "../../../../../shared/runtime.js";
import { _ as G } from "../../../../../modules/index-3b2628f3.js";
const J = { class: "tip" }, Q = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(e, { emit: x }) {
  const L = d(), b = d(), V = x, a = e, { visible: u, handleClose: E } = z({ emit: V, props: a, field: "visible" }), { maxHeight: M } = K({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b), p = v("handleMethodEnumV"), R = v("handleMethodEnum"), m = d(false), h = d([]);
  D(() => a.visible, (l) => {
    l ? B() : k();
  }, { immediate: true });
  function k() {
    h.value = [];
  }
  async function B() {
    var o, r;
    let l = [];
    try {
      if (m.value = true, a.info.handleType === R.DECREASE_TASK.V) {
        const { content: i } = await U({ productType: (o = a.info) == null ? void 0 : o.productType, productId: (r = a.info) == null ? void 0 : r.productId });
        l = i;
      } else {
        const { reportList: i } = await O({ productType: a.info.productType, productId: a.info.productId });
        l = i.map((s) => (s.reportTypeText = P.VL[s.reportType], s));
      }
    } catch {
      console.log("获取处理列表失败");
    } finally {
      h.value = l, m.value = false;
    }
  }
  return (l, o) => {
    const r = A, i = T("common-table"), s = T("common-drawer"), C = F;
    return c(), _(s, { ref_key: "drawerRef", ref: b, title: `${e.info.handleType && n(p)[e.info.handleType].L}详情：${e.info.serialNumber}`, modelValue: n(u), "onUpdate:modelValue": o[0] || (o[0] = (t) => j(u) ? u.value = t : null), direction: "rtl", "before-close": n(E), size: "60%" }, { content: y(() => [f("div", J, [o[1] || (o[1] = f("span", null, "* 注意：", -1)), f("span", null, " 可操作" + w(e.info.handleType && n(p)[e.info.handleType].L) + "的构件数量总和为" + w(e.info.canHandleTotalMete) + "，请谨慎操作！", 1)]), H((c(), _(i, { ref_key: "tableRef", ref: L, data: h.value, "max-height": n(M), style: { width: "100%" } }, { default: y(() => [g(r, { label: "序号", type: "index", align: "center", width: "60" }), g(n(G), { showProductionLine: "", showFactory: "" }), (c(true), S(N, null, $(n(p)[e.info.handleType].COLUMNS || [], (t) => (c(), _(r, { key: t.field, prop: t.field, "show-overflow-tooltip": true, label: t.label, width: t.width, align: t.align }, { default: y((I) => [f("span", null, w(I.row[t.field]), 1)]), _: 2 }, 1032, ["prop", "label", "width", "align"]))), 128))]), _: 1 }, 8, ["data", "max-height"])), [[C, m.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, te = q(Q, [["__scopeId", "data-v-853479ef"]]);
export {
  te as default
};
