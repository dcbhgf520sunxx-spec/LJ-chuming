import { ref as s } from "vue";
import { computed as d } from "vue";
import { provide as I } from "vue";
import { watch as h } from "vue";
import { openBlock as x } from "vue";
import { createBlock as q } from "vue";
import { withCtx as k } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as c } from "vue";
import { ElForm as w } from "element-plus";
import { a as F } from "../../../../../../../modules/application-0ee072a2.js";
import { _ as W, bC as U, b as C, V, x_ as B } from "../../../../../../../shared/runtime.js";
import j from "../components/common-form-item.vue.js";
import P from "../components/common-material-info.vue.js";
import "../../../../../../../modules/workshop-select-210dd661.js";
const Q = { class: "material-info" }, E = { class: "form-info" }, M = { __name: "aux-mat", props: { basicClass: { type: Number }, material: { type: Object } }, setup(f, { expose: p }) {
  const v = f, n = (r, e, a) => {
    if (C(e)) return a(new Error("请填写数量"));
    if (e <= 0) return a(new Error("数量必须大于0"));
    if (e > l.value) return a(new Error("数量不可超过可操作数量"));
    a();
  }, u = s({ directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: n, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] }), o = s(), t = s({}), i = d(() => v.material || {});
  U(o, t, ["quantity"]);
  const l = d(() => !t.value || !t.value.projectId || !i.value.projectFrozenForUnitKV ? i.value.corOperableQuantity : i.value.corOperableQuantity + (i.value.projectFrozenForUnitKV[t.value.projectId] || 0));
  I("maxQuantity", l), h(i, (r) => {
    _(r);
  }, { immediate: true });
  function _(r) {
    const e = { directionWarehouseId: void 0, directionWorkshopId: void 0, materialId: r.id, outboundUnit: r.outboundUnit, outboundUnitPrecision: r.outboundUnitPrecision, basicClass: r.basicClass, boolPartyA: r.boolPartyA, quantity: void 0, remark: void 0 };
    t.value = e, u.value = { directionWorkshopId: [{ required: true, message: "请选择仓库", trigger: "blur" }], directionWarehouseId: [{ required: true, message: "请选择存储位置", trigger: "blur" }], quantity: [{ required: true, validator: n, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }] };
  }
  async function b() {
    if (!await o.value.validate()) return false;
    const e = V(t.value);
    await B(e, { unit: e.outboundUnit, precision: e.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true });
    const a = { directionWarehouseId: e.directionWarehouseId, directionWorkshopId: e.directionWorkshopId, basicClass: e.basicClass, detailList: [{ materialId: e.materialId, quantity: e.quantity, remark: e.remark }] };
    return await F(a);
  }
  function g() {
    o.value.resetFields();
  }
  function y() {
    o.value && o.value.clearValidate();
  }
  return p({ submit: b, resetForm: g, clearValidate: y }), (r, e) => {
    const a = w;
    return x(), q(a, { ref_key: "formRef", ref: o, model: t.value, rules: u.value, class: "form", "label-position": "left", "label-width": "120px", size: "default" }, { default: k(() => [m("div", Q, [c(P, { form: t.value, material: i.value }, null, 8, ["form", "material"])]), m("div", E, [c(j, { form: t.value, material: i.value }, null, 8, ["form", "material"])])]), _: 1 }, 8, ["model", "rules"]);
  };
} }, H = W(M, [["__scopeId", "data-v-5b53556d"]]);
export {
  H as default
};
