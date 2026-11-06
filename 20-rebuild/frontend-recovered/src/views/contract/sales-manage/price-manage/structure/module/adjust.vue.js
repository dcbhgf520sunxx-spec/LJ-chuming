import { computed as T } from "vue";
import { watch as D } from "vue";
import { ref as d } from "vue";
import { nextTick as F } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as m } from "vue";
import { createBlock as p } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { withModifiers as M } from "vue";
import { createTextVNode as v } from "vue";
import { withDirectives as P } from "vue";
import { toDisplayString as c } from "vue";
import { unref as y } from "vue";
import { createElementVNode as V } from "vue";
import { isRef as O } from "vue";
import { ElFormItem as $ } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElForm as H } from "element-plus";
import { vLoading as J } from "element-plus";
import { b as K, d as Q } from "../../../../../../modules/structure-70e27af9.js";
import { _ as W, u as X, kE as g } from "../../../../../../shared/runtime.js";
const Y = { class: "option-item" }, Z = { class: "label" }, ee = { __name: "adjust", props: { detail: { type: Object, default: () => {
} }, structureId: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true } }, emits: ["success"], setup(k, { emit: B }) {
  const I = B, l = k, { visible: f, handleClose: w } = X({ emit: I, props: l }), _ = T(() => t.value.modifyType === g.SEPARATE.V), N = T(() => {
    const o = {};
    return _.value ? o.name = [{ required: true, message: "请填重新命名", trigger: "blur" }] : o.businessId = [{ required: true, message: "请选择", trigger: "change" }], o;
  });
  D(() => l.modelValue, (o) => {
    o && (j(), C());
  }, { deep: true, immediate: true });
  const x = { name: "", businessId: void 0, modifyType: g.SEPARATE.V }, u = d(), h = d([]), t = d({ ...x }), E = d(false);
  function R() {
    u.value.validate(async (o) => {
      if (o) {
        const e = { productId: l.detail.id };
        _.value ? e.name = t.value.name : e.businessId = t.value.businessId, await Q(e), I("success"), w();
      }
      return false;
    });
  }
  function j() {
    t.value = { ...x }, F(() => {
      u.value && u.value.resetFields();
    });
  }
  async function C() {
    let o = [];
    try {
      if (l.detail.monomerId) {
        const { content: b = [] } = await K({ monomerId: l.detail.monomerId });
        o = b.filter((n) => n.id !== l.structureId);
      }
    } catch (e) {
      console.log("获取商务构件列表失败", e);
    } finally {
      h.value = o;
    }
  }
  return (o, e) => {
    const b = r("common-button"), n = $, S = r("common-radio"), U = G, q = r("common-select"), z = H, A = r("common-dialog"), L = J;
    return m(), p(A, { title: `${l.detail.name}调整`, "append-to-body": "", modelValue: y(f), "onUpdate:modelValue": e[3] || (e[3] = (s) => O(f) ? f.value = s : null), width: "440px", "show-close": "", "before-close": y(w), top: "10vh" }, { titleRight: a(() => [i(b, { size: "default", type: "primary", onClick: M(R, ["stop"]) }, { default: a(() => e[4] || (e[4] = [v("确认")])), _: 1, __: [4] })]), default: a(() => [P((m(), p(z, { ref_key: "formRef", ref: u, disabled: E.value, model: t.value, rules: N.value, size: "default", "label-width": "80px" }, { default: a(() => [i(n, { label: "名称" }, { default: a(() => [v(c(l.detail.name), 1)]), _: 1 }), i(n, { label: "编号", prop: "serialNumber" }, { default: a(() => [v(c(l.detail.serialNumber), 1)]), _: 1 }), i(n, { label: "类型", prop: "modifyType" }, { default: a(() => [i(S, { modelValue: t.value.modifyType, "onUpdate:modelValue": e[0] || (e[0] = (s) => t.value.modifyType = s), options: y(g).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), _.value ? (m(), p(n, { key: 0, label: "重新命名", prop: "name" }, { default: a(() => [i(U, { modelValue: t.value.name, "onUpdate:modelValue": e[1] || (e[1] = (s) => t.value.name = s), placeholder: "请重新命名", size: "default", class: "input-underline", style: { width: "300px" }, clearable: "" }, null, 8, ["modelValue"])]), _: 1 })) : (m(), p(n, { key: 1, label: "合并", prop: "businessId" }, { default: a(() => [i(q, { modelValue: t.value.businessId, "onUpdate:modelValue": e[2] || (e[2] = (s) => t.value.businessId = s), options: h.value, clearable: "", filterable: "", class: "input-underline", placeholder: "请选择", style: { width: "300px" } }, { view: a(({ data: s }) => [V("span", Y, [V("span", null, c(s.name), 1), V("span", Z, c(s.material), 1)])]), _: 1 }, 8, ["modelValue", "options"])]), _: 1 }))]), _: 1 }, 8, ["disabled", "model", "rules"])), [[L, E.value]])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ae = W(ee, [["__scopeId", "data-v-be40a76f"]]);
export {
  ae as default
};
