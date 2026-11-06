import { ref as u } from "vue";
import { computed as s } from "vue";
import { provide as h } from "vue";
import { watch as x } from "vue";
import { openBlock as F } from "vue";
import { createBlock as w } from "vue";
import { withCtx as j } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as d } from "vue";
import { ElForm as q } from "element-plus";
import { _ as V, bC as U, qS as B, yV as C, b as E, V as O, x_ as Q } from "../../../../../../../shared/runtime.js";
import k from "../components/common-form-item.vue.js";
import A from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const N = { class: "material-info" }, z = { class: "form-info" }, P = { __name: "other", props: { basicClass: { type: Number }, material: { type: Object } }, setup(f, { expose: p }) {
  const v = f, l = (e, r, t) => {
    if (E(r)) return t(new Error("请填写数量"));
    if (r <= 0) return t(new Error("数量必须大于0"));
    if (r > m.value) return t(new Error("数量不可超过可操作数量"));
    t();
  }, i = u({ quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }), a = u(), o = u({}), n = s(() => v.material || {});
  U(a, o, ["quantity"]);
  const m = s(() => !o.value || !o.value.projectId || !n.value.projectFrozenForUnitKV ? n.value.corOperableQuantity : n.value.corOperableQuantity + (n.value.projectFrozenForUnitKV[o.value.projectId] || 0));
  h("maxQuantity", m), x(n, (e) => {
    _(e);
  }, { immediate: true });
  function _(e) {
    var t;
    const r = { materialId: e.id, monomerId: e == null ? void 0 : e.monomerId, areaId: e == null ? void 0 : e.areaId, factoryId: (t = e.factory) == null ? void 0 : t.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, outboundAddress: B.FACTORY.V, projectId: e.project ? e.project.id : void 0, recipientId: void 0, quantity: void 0, remark: void 0 };
    o.value = r, i.value = { outboundAddress: [{ required: true, message: "出库目的地", trigger: "change" }], quantity: [{ required: true, validator: l, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }, r.projectId && (i.value.projectId = { required: true, message: "项目库辅材必须选择项目出库", trigger: "change" });
  }
  const b = s(() => C);
  async function g() {
    if (!await a.value.validate()) return false;
    const r = O(o.value);
    return await Q(r, { unit: r.outboundUnit, precision: r.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await b.value(r);
  }
  function y() {
    a.value.resetFields();
  }
  function I() {
    a.value && a.value.clearValidate();
  }
  return p({ submit: g, resetForm: y, clearValidate: I }), (e, r) => {
    const t = q;
    return F(), w(t, { ref_key: "formRef", ref: a, model: o.value, rules: i.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: j(() => [c("div", N, [d(A, { form: o.value, material: n.value }, null, 8, ["form", "material"])]), c("div", z, [d(k, { form: o.value, material: n.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, H = V(P, [["__scopeId", "data-v-a686e4bb"]]);
export {
  H as default
};
