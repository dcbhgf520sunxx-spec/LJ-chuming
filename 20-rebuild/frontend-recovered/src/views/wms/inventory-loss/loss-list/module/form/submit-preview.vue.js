import { _ as g, u as C, o as h, xF as I, hg as V, xG as P, xH as T } from "../../../../../../shared/runtime.js";
import { ref as c } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as U } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as f } from "vue";
import { createTextVNode as F } from "vue";
import { unref as o } from "vue";
import { isRef as H } from "vue";
import { ElMessage as k } from "element-plus";
const B = { __name: "submit-preview", props: { modelValue: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, form: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "submit"], setup(i, { emit: b }) {
  const l = c(), u = b, s = i, { visible: n, handleClose: d } = C({ emit: u, props: s }), a = c(false), { maxHeight: p } = h({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, l);
  async function _() {
    a.value = true;
    try {
      const t = { deficitType: s.form.deficitType, basicClass: void 0, list: [] };
      s.list.forEach((e) => {
        t.basicClass = t.basicClass ? t.basicClass | e.basicClass : e.basicClass, t.list.push({ factoryId: e.factoryId, materialId: e.materialId, projectId: s.form.deficitType === V.PROJECT.V ? e.deficitProjectId : void 0, quantity: e.diffQuantity, outboundUnitPrecision: e.outboundUnitPrecision, outboundUnit: e.outboundUnit, remark: e.remark, realTime: e.realTime });
      }), await P(t.list, { unitField: "outboundUnit", unitPrecisionField: "outboundUnitPrecision", fields: ["quantity"], toSmallest: true, toNum: true }), await T(t), k.success("盘亏提交成功"), u("success"), d(), a.value = false;
    } catch {
      a.value = false;
    }
  }
  return (t, e) => {
    const y = m("common-button"), x = m("common-drawer");
    return U(), v(x, { ref_key: "drawerRef", ref: l, modelValue: o(n), "onUpdate:modelValue": e[0] || (e[0] = (w) => H(n) ? n.value = w : null), "before-close": o(d), direction: "rtl", size: "100%", title: "提交预览" }, { titleRight: r(() => [f(y, { loading: a.value, size: "default", type: "primary", onClick: _ }, { default: r(() => e[1] || (e[1] = [F(" 发起审批 ")])), _: 1, __: [1] }, 8, ["loading"])]), content: r(() => [f(o(I), { list: i.list, form: i.form, maxHeight: o(p) }, null, 8, ["list", "form", "maxHeight"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, E = g(B, [["__scopeId", "data-v-f2254e69"]]);
export {
  E as default
};
