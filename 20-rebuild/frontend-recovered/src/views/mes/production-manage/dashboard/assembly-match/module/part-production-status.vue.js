import { ref as h } from "vue";
import { computed as R } from "vue";
import { watch as D } from "vue";
import { inject as E } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as n } from "vue";
import { createBlock as k } from "vue";
import { withCtx as t } from "vue";
import { createElementBlock as p } from "vue";
import { withDirectives as I } from "vue";
import { createVNode as a } from "vue";
import { unref as u } from "vue";
import { createCommentVNode as d } from "vue";
import { createElementVNode as l } from "vue";
import { Fragment as M } from "vue";
import { renderList as j } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as i } from "vue";
import { normalizeStyle as q } from "vue";
import { isRef as F } from "vue";
import { ElTag as P } from "element-plus";
import { ElTableColumn as U } from "element-plus";
import { d as G } from "../../../../../../modules/assembly-match-4f9c2c34.js";
import { u as J, o as K, a3 as O } from "../../../../../../shared/runtime.js";
const W = { key: 0, class: "print-wrap" }, X = { key: 0, class: "nameViews" }, Y = { key: 2, style: { color: "red" } }, te = { __name: "part-production-status", props: { visible: { type: Boolean, default: false }, ids: { type: Array, default: () => [] }, names: { type: Array, default: () => [] }, isIncludeboolHaveTask: { type: Boolean, default: false } }, emits: ["update:visible"], setup(v, { emit: g }) {
  const b = h(), x = g, r = v, m = R(() => y.value.length > 0 || r.isIncludeboolHaveTask), { visible: f, handleClose: V } = J({ emit: x, props: r, field: "visible" }), { maxHeight: N } = K({ extraBox: [".el-drawer__header", ".nameViews"], extraHeight: 10, wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b);
  D(() => r.visible, (s) => {
    s && L();
  }, { immediate: true });
  const w = h(false), y = h([]), T = E("permission");
  async function L() {
    try {
      w.value = true;
      const s = await G({ ids: r.ids });
      y.value = s;
    } catch (s) {
      console.log("获取零件生产状态", s);
    } finally {
      w.value = false;
    }
  }
  return (s, c) => {
    const B = _("print-table"), Q = P, o = U, H = _("common-table"), S = _("common-drawer"), C = z("permission");
    return n(), k(S, { ref_key: "drawerRef", ref: b, title: "零部件生产状态", modelValue: u(f), "onUpdate:modelValue": c[0] || (c[0] = (e) => F(f) ? f.value = e : null), contentLoading: w.value, direction: "rtl", "before-close": u(V), size: "70%" }, { titleRight: t(() => [m.value ? (n(), p("div", W, [I(a(B, { "api-key": "mesMachinePartDetail", params: { ids: r.ids }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[C, u(T).print]])])) : d("", true)]), content: t(() => [m.value ? (n(), p("div", X, [c[1] || (c[1] = l("span", null, "构件：", -1)), (n(true), p(M, null, j(v.names, (e) => (n(), p("span", { key: e.name }, [a(Q, { type: e.tagType, effect: "plain", style: { "margin-right": "5px", "margin-bottom": "5px" } }, { default: t(() => [A(i(e.name), 1)]), _: 2 }, 1032, ["type"])]))), 128))])) : d("", true), m.value ? (n(), k(H, { key: 1, data: y.value, "max-height": u(N), style: { width: "100%", "margin-top": "10px" } }, { default: t(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { key: "productType", prop: "productType", "show-overflow-tooltip": true, label: "类别", "min-width": "140" }, { default: t((e) => [l("span", null, i(u(O).VL[e.row.productType]), 1)]), _: 1 }), a(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "140" }, { default: t((e) => [l("span", null, i(e.row.serialNumber), 1)]), _: 1 }), a(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140" }, { default: t((e) => [l("span", null, i(e.row.specification), 1)]), _: 1 }), a(o, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度", "min-width": "100" }, { default: t((e) => [l("span", null, i(e.row.length), 1)]), _: 1 }), a(o, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "100" }, { default: t((e) => [l("span", null, i(e.row.material), 1)]), _: 1 }), a(o, { key: "workShopLineName", prop: "workShopLineName", "show-overflow-tooltip": true, label: "任务班组", "min-width": "140" }, { default: t((e) => [l("span", null, i(e.row.workShopLineName), 1)]), _: 1 }), a(o, { key: "taskQuantity", prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数", "min-width": "100" }, { default: t((e) => [l("span", null, i(e.row.taskQuantity), 1)]), _: 1 }), a(o, { key: "companyQuantity", prop: "companyQuantity", "show-overflow-tooltip": true, label: "完成数", "min-width": "100" }, { default: t(({ row: e }) => [l("span", { style: q({ color: e.companyQuantity >= e.taskQuantity ? "#00751f" : "#ff0f1a" }) }, i(e.companyQuantity), 5)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : d("", true), m.value ? d("", true) : (n(), p("div", Y, " *构件未排产 "))]), _: 1 }, 8, ["modelValue", "contentLoading", "before-close"]);
  };
} };
export {
  te as default
};
