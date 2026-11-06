import { bl as s, u as k, kc as T, i as L } from "../../../../../../../shared/runtime.js";
import r from "./form/steel-plate.vue.js";
import x from "./form/section-steel.vue.js";
import A from "./form/aux-material.vue.js";
import { computed as f } from "vue";
import { ref as S } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as p } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createVNode as y } from "vue";
import { createTextVNode as C } from "vue";
import { resolveDynamicComponent as B } from "vue";
import { unref as V } from "vue";
import { isRef as N } from "vue";
import { ElMessage as F } from "element-plus";
import "../../../../../../../modules/use-purchase-material-form-info-d099f05d.js";
const D = { __name: "dialog", props: { modelValue: { type: Boolean, default: false }, technologyRow: { type: Object, default: () => ({}) } }, emits: ["update:modelValue", "success"], setup(c, { emit: g }) {
  const i = g, t = c, w = f(() => {
    switch (t.technologyRow.basicClass) {
      case s.STEEL_PLATE.V:
        return r;
      case s.SECTION_STEEL.V:
        return x;
      case s.STEEL_COIL.V:
        return r;
      case s.MATERIAL.V:
        return A;
      case s.GAS.V:
      default:
        return r;
    }
  }), a = S(), { visible: n, handleClose: u } = k({ emit: i, props: t, field: "modelValue" }), { crud: b } = T(), E = f(() => {
    const e = b.props.steelClassifyConfICKV;
    return L(e) ? e[t.technologyRow.steelClassifyConfId] || [] : [];
  });
  async function R() {
    const e = await a.value.add();
    e && (i("success", e, t.technologyRow), u(), F.success("添加成功"));
  }
  function h() {
    a.value.resetForm();
  }
  return (e, o) => {
    const m = d("common-button"), v = d("common-dialog");
    return p(), _(v, { title: "新增采购物料", modelValue: V(n), "onUpdate:modelValue": o[0] || (o[0] = (I) => N(n) ? n.value = I : null), "before-close": V(u), width: 400 }, { titleRight: l(() => [y(m, { type: "success", size: "default", onClick: R }, { default: l(() => o[1] || (o[1] = [C("确认添加")])), _: 1, __: [1] }), y(m, { type: "warning", size: "default", onClick: h }, { default: l(() => o[2] || (o[2] = [C("重置")])), _: 1, __: [2] })]), default: l(() => [(p(), _(B(w.value), { ref_key: "formRef", ref: a, "technology-row": c.technologyRow, "classify-ids": E.value }, null, 8, ["technology-row", "classify-ids"]))]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  D as default
};
