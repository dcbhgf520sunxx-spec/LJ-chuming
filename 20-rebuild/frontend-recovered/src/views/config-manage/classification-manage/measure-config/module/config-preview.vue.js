import { inject as v } from "vue";
import { computed as S } from "vue";
import { ref as $ } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as s } from "vue";
import { createBlock as g } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as j } from "vue";
import { toDisplayString as b } from "vue";
import { createElementBlock as x } from "vue";
import { createCommentVNode as c } from "vue";
import { isRef as H } from "vue";
import { ElNotification as A } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { l as w, b_ as F, u as L, o as R, b as z } from "../../../../../shared/runtime.js";
import { _ as d } from "../../../../../modules/index-61ce89a1.js";
function W() {
  return w({ module: "config", url: "classification/material/measure", method: "get" });
}
function D(i) {
  return w({ module: "config", url: "classification/material/measure", method: "put", data: i });
}
function X(i) {
  return w({ url: "/api/config/classification/material/measure/exportMeteringConfigurationList", method: "get", responseType: "blob", timeout: 6e7, params: i });
}
const I = { key: 0 }, O = { key: 0 }, q = { __name: "config-preview", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] }, level: { type: Number, default: 3 } }, emits: ["saveSuccess", "update:visible"], setup(i, { emit: N }) {
  const _ = N, h = i, U = v("refreshFunc"), P = v("sourceMap"), m = S(() => h.data.filter((r) => F(r, P))), f = $(false), { visible: u, handleClose: y } = L({ emit: _, props: h, field: "visible" }), { maxHeight: k } = R({ mainBox: ".class-measure-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, u);
  async function C() {
    try {
      f.value = true;
      const r = m.value.map((o) => ({ id: o.id, measureUnit: o.measureUnit, accountingUnit: o.accountingUnit, accountingPrecision: o.accountingPrecision, measurePrecision: o.measurePrecision, outboundUnitType: o.outboundUnitType }));
      await D(r), y(), U(), _("saveSuccess"), A({ title: "修改成功", type: "success" });
    } catch (r) {
      console.log("计量配置批量修改", r);
    } finally {
      f.value = false;
    }
  }
  return (r, o) => {
    const B = p("common-button"), l = E, M = p("common-table"), V = p("common-dialog");
    return s(), g(V, { "custom-class": "class-measure-preview", title: "变更详情", "append-to-body": "", modelValue: n(u), "onUpdate:modelValue": o[0] || (o[0] = (e) => H(u) ? u.value = e : null), width: "1200px", "before-close": n(y), top: "5vh" }, { titleRight: a(() => [t(B, { loading: f.value, disabled: n(z)(m.value), type: "primary", size: "default", onClick: C }, { default: a(() => o[1] || (o[1] = [T("保 存")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: a(() => [t(M, { data: m.value, "max-height": n(k), "empty-text": "未做改动", "row-key": "id" }, { default: a(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { "show-overflow-tooltip": true, prop: "first", label: "一级科目" }, { default: a((e) => [j("span", null, b(`${e.row.fullName[0]}-${e.row.fullSerialNumber[0]}`), 1)]), _: 1 }), i.level > 1 ? (s(), g(l, { key: 0, "show-overflow-tooltip": true, prop: "second", label: "二级科目" }, { default: a((e) => [e.row.fullName.length > 1 ? (s(), x("span", I, b(`${e.row.fullName[1]}-${e.row.fullSerialNumber[1]}`), 1)) : c("", true)]), _: 1 })) : c("", true), i.level > 2 ? (s(), g(l, { key: 1, "show-overflow-tooltip": true, prop: "third", label: "三级科目" }, { default: a((e) => [e.row.fullName.length > 2 ? (s(), x("span", O, b(`${e.row.fullName[2]}-${e.row.fullSerialNumber[2]}`), 1)) : c("", true)]), _: 1 })) : c("", true), t(l, { label: "计量单位", align: "center" }, { default: a((e) => [t(n(d), { old: e.row.sourceMeasureUnit, new: e.row.measureUnit }, null, 8, ["old", "new"])]), _: 1 }), t(l, { label: "小数精度(计量)", align: "center" }, { default: a((e) => [t(n(d), { old: e.row.sourceMeasurePrecision, new: e.row.measurePrecision }, null, 8, ["old", "new"])]), _: 1 }), t(l, { prop: "accountingUnit", label: "核算单位", align: "center" }, { default: a((e) => [t(n(d), { old: e.row.sourceAccountingUnit, new: e.row.accountingUnit }, null, 8, ["old", "new"])]), _: 1 }), t(l, { label: "小数精度(核算)", align: "center" }, { default: a((e) => [t(n(d), { old: e.row.sourceAccountingPrecision, new: e.row.accountingPrecision }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, G = q, Y = Object.freeze(Object.defineProperty({ __proto__: null, default: G }, Symbol.toStringTag, { value: "Module" }));
export {
  Y as a,
  G as c,
  X as e,
  W as g
};
