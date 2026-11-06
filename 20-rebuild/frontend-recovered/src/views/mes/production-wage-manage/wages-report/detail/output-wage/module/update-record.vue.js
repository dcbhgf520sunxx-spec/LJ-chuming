import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as n } from "vue";
import { withCtx as t } from "vue";
import { createVNode as d } from "vue";
import { createTextVNode as l } from "vue";
import { toDisplayString as a } from "vue";
import { unref as c } from "vue";
import { createCommentVNode as u } from "vue";
import { isRef as x } from "vue";
import { ElDescriptionsItem as N } from "element-plus";
import { ElDescriptions as V } from "element-plus";
import { _ as h, u as k, p as w } from "../../../../../../../shared/runtime.js";
const C = { __name: "update-record", props: { info: { type: Object, default: () => {
} }, type: { type: String, default: "" } }, emits: ["update:visible"], setup(e, { emit: f }) {
  const m = e, b = f, { visible: s, handleClose: p } = k({ emit: b, props: m, field: "visible" });
  return (j, r) => {
    const o = N, y = V, _ = g("common-dialog");
    return i(), n(_, { "append-to-body": "", modelValue: c(s), "onUpdate:modelValue": r[0] || (r[0] = (v) => x(s) ? s.value = v : null), top: "10vh", width: "600px", "before-close": c(p), title: "修改记录" }, { default: t(() => [d(y, { column: 1, class: "descriptions" }, { default: t(() => [d(o, { label: "项目：" }, { default: t(() => [l(a(e.info.projectSerialNumber) + " " + a(e.info.projectName || "-"), 1)]), _: 1 }), d(o, { label: "编号：" }, { default: t(() => [l(a(e.info.productSerialNumber || "-"), 1)]), _: 1 }), d(o, { label: "修改人：" }, { default: t(() => [l(a(e.info.operatorName || "-"), 1)]), _: 1 }), d(o, { label: "修改日期：" }, { default: t(() => [l(a(e.info.updateTime ? c(w)(e.info.updateTime, "{y}-{m}-{d}  {h}:{i}:{s}") : "-"), 1)]), _: 1 }), e.type === "weight" ? (i(), n(o, { key: 0, label: "清单计量量：" }, { default: t(() => [l(a(e.info.oldMeasureQuantity || "-"), 1)]), _: 1 })) : u("", true), e.type === "weight" ? (i(), n(o, { key: 1, label: "修改后计量量：" }, { default: t(() => [l(a(e.info.newMeasureQuantity || "-"), 1)]), _: 1 })) : u("", true), e.type === "unitPrice" ? (i(), n(o, { key: 2, label: "定额单价：" }, { default: t(() => [l(a(e.info.oldQuotaPrice || "-"), 1)]), _: 1 })) : u("", true), e.type === "unitPrice" ? (i(), n(o, { key: 3, label: "修改后单价：" }, { default: t(() => [l(a(e.info.newQuotaPrice || "-"), 1)]), _: 1 })) : u("", true)]), _: 1 })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Q = h(C, [["__scopeId", "data-v-f44936a2"]]);
export {
  Q as default
};
