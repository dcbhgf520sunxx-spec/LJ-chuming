import { ref as r } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as o } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as p } from "vue";
import { unref as d } from "vue";
import { Fragment as R } from "vue";
import { renderList as V } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as L } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as T } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElCard as O } from "element-plus";
import { _ as W, i as E, fb as F } from "../../../../../../../../shared/runtime.js";
import $ from "../../../component/form.vue.js";
const q = { __name: "index", props: { data: { type: Array, default: () => [] } }, emits: ["success"], setup(_, { emit: v }) {
  const b = _, y = v, g = r(), C = [], n = r(false), m = r({});
  function w(u) {
    m.value = u, n.value = true;
  }
  return (u, t) => {
    const i = I, k = f("common-button"), x = f("common-table"), D = O, h = N("permission");
    return s(), c("div", null, [o(D, { shadow: "always", class: "section-config" }, { header: a(() => t[2] || (t[2] = [p("div", { class: "clearfix" }, [p("span", { class: "card-title" }, "截面类型库")], -1)])), default: a(() => [o(x, { ref_key: "tableRef", ref: g, "data-format": C, data: b.data }, { default: a(() => [o(i, { key: "typeName", "show-overflow-tooltip": true, prop: "typeName", label: "类型", align: "center", width: "120" }), o(i, { key: "sectionWarehouseConfigDTOList", prop: "sectionWarehouseConfigDTOList", label: "名称分类", align: "left" }, { default: a(({ row: { sourceRow: e } }) => [d(E)(e.sectionWarehouseConfigDTOList) ? (s(true), c(R, { key: 0 }, V(e.sectionWarehouseConfigDTOList, (l) => (s(), c("span", { key: l.name }, " 【" + B(l.name) + "】 ", 1))), 128)) : L("", true)]), _: 1 }), S((s(), T(i, { label: "操作", width: "100px", align: "center", fixed: "right" }, { default: a(({ row: { sourceRow: e } }) => [o(k, { icon: "el-icon-edit", type: "primary", size: "default", onClick: (l) => w(e) }, null, 8, ["onClick"])]), _: 1 })), [[h, d(F).edit]])]), _: 1 }, 8, ["data"])]), _: 1 }), o(d($), { modelValue: n.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => n.value = e), onSuccess: t[1] || (t[1] = (e) => y("success")), detailInfo: m.value }, null, 8, ["modelValue", "detailInfo"])]);
  };
} }, P = W(q, [["__scopeId", "data-v-a5554bb5"]]);
export {
  P as default
};
