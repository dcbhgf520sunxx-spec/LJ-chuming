import { ref as m } from "vue";
import { watch as H } from "vue";
import { inject as L } from "vue";
import { resolveComponent as u } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as f } from "vue";
import { createBlock as T } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as i } from "vue";
import { withDirectives as E } from "vue";
import { createVNode as a } from "vue";
import { unref as p } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as M } from "vue";
import { renderList as j } from "vue";
import { createTextVNode as z } from "vue";
import { toDisplayString as n } from "vue";
import { isRef as A } from "vue";
import { ElTag as S } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { d as F } from "../../../../../../modules/assembly-match-ac180441.js";
import { u as I, o as P } from "../../../../../../shared/runtime.js";
const U = { class: "print-wrap" }, G = { class: "nameViews" }, W = { __name: "part-production-status", props: { visible: { type: Boolean, default: false }, ids: { type: Array, default: () => [] }, names: { type: Array, default: () => [] } }, emits: ["update:visible"], setup(w, { emit: h }) {
  const _ = m(), g = h, l = w, { visible: d, handleClose: v } = I({ emit: g, props: l, field: "visible" }), { maxHeight: x } = P({ extraBox: [".el-drawer__header", ".nameViews"], extraHeight: 10, wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, _);
  H(() => l.visible, (o) => {
    o && V();
  }, { immediate: true });
  const c = m(false), b = m([]), k = L("permission");
  async function V() {
    try {
      c.value = true;
      const o = await F({ ids: l.ids });
      b.value = o;
    } catch (o) {
      console.log("获取零件生产状态", o);
    } finally {
      c.value = false;
    }
  }
  return (o, r) => {
    const B = u("print-table"), N = S, s = q, Q = u("common-table"), R = u("common-drawer"), C = D("permission");
    return f(), T(R, { ref_key: "drawerRef", ref: _, title: "零件生产状态", modelValue: p(d), "onUpdate:modelValue": r[0] || (r[0] = (e) => A(d) ? d.value = e : null), contentLoading: c.value, direction: "rtl", "before-close": p(v), size: "50%" }, { titleRight: t(() => [i("div", U, [E(a(B, { "api-key": "bridgeMachinePartDetail", params: { ids: l.ids }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[C, p(k).print]])])]), content: t(() => [i("div", G, [r[1] || (r[1] = i("span", null, "分段：", -1)), (f(true), y(M, null, j(w.names, (e) => (f(), y("span", { key: e.name }, [a(N, { type: e.tagType, effect: "plain", style: { "margin-right": "5px", "margin-bottom": "5px" } }, { default: t(() => [z(n(e.name), 1)]), _: 2 }, 1032, ["type"])]))), 128))]), a(Q, { data: b.value, "max-height": p(x), style: { width: "100%", "margin-top": "10px" } }, { default: t(() => [a(s, { label: "序号", type: "index", align: "center", width: "60" }), a(s, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140" }, { default: t((e) => [i("span", null, n(e.row.serialNumber), 1)]), _: 1 }), a(s, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140" }, { default: t((e) => [i("span", null, n(e.row.specification), 1)]), _: 1 }), a(s, { key: "needQuantity", prop: "needQuantity", "show-overflow-tooltip": true, label: "所需数量", "min-width": "100" }, { default: t((e) => [i("span", null, n(e.row.needQuantity), 1)]), _: 1 }), a(s, { key: "usableQuantity", prop: "usableQuantity", "show-overflow-tooltip": true, label: "可使用", "min-width": "100" }, { default: t((e) => [i("span", null, n(e.row.usableQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "contentLoading", "before-close"]);
  };
} };
export {
  W as default
};
