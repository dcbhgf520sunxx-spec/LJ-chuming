import { ref as c } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as S } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as p } from "vue";
import { unref as l } from "vue";
import { Fragment as h } from "vue";
import { renderList as R } from "vue";
import { normalizeStyle as V } from "vue";
import { toDisplayString as E } from "vue";
import { createCommentVNode as I } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as B } from "vue";
import { ElTableColumn as L } from "element-plus";
import { ElCard as O } from "element-plus";
import { _ as W, i as A, fd as F, fb as $ } from "../../../../../../../../shared/runtime.js";
import z from "../../../component/form.vue.js";
const U = { __name: "index", props: { data: { type: Array, default: () => [] } }, emits: ["success"], setup(_, { emit: v }) {
  const y = _, b = v, g = c(), C = [], i = c(false), m = c({});
  function w(u) {
    m.value = u, i.value = true;
  }
  return (u, t) => {
    const r = L, k = f("common-button"), x = f("common-table"), D = O, N = S("permission");
    return n(), d("div", null, [o(D, { shadow: "always", class: "section-config" }, { header: a(() => t[2] || (t[2] = [p("div", { class: "clearfix" }, [p("span", { class: "card-title" }, "截面类型库")], -1)])), default: a(() => [o(x, { ref_key: "tableRef", ref: g, "data-format": C, data: y.data }, { default: a(() => [o(r, { key: "typeName", "show-overflow-tooltip": true, prop: "typeName", label: "类型", align: "center", width: "120" }), o(r, { key: "sectionWarehouseConfigDTOList", prop: "sectionWarehouseConfigDTOList", label: "名称分类", align: "left" }, { default: a(({ row: { sourceRow: e } }) => [l(A)(e.sectionWarehouseConfigDTOList) ? (n(true), d(h, { key: 0 }, R(e.sectionWarehouseConfigDTOList, (s) => (n(), d("span", { key: s.name, style: V(`color:${s.source === l(F).USER_ADDITION.V ? "#E6A23C" : ""}`) }, " 【" + E(s.name) + "】 ", 5))), 128)) : I("", true)]), _: 1 }), T((n(), B(r, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: a(({ row: { sourceRow: e } }) => [o(k, { icon: "el-icon-edit", type: "primary", size: "default", onClick: (s) => w(e) }, null, 8, ["onClick"])]), _: 1 })), [[N, l($).edit]])]), _: 1 }, 8, ["data"])]), _: 1 }), o(l(z), { modelValue: i.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => i.value = e), onSuccess: t[1] || (t[1] = (e) => b("success")), detailInfo: m.value }, null, 8, ["modelValue", "detailInfo"])]);
  };
} }, j = W(U, [["__scopeId", "data-v-95f28405"]]);
export {
  j as default
};
