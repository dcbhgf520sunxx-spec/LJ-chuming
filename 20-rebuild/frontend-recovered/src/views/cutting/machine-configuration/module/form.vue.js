import { ref as m } from "vue";
import { computed as R } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as O } from "vue";
import { createBlock as L } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { ElInput as x } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElForm as E } from "element-plus";
import { ao as S, b4 as z, lY as A, aV as B } from "../../../../shared/runtime.js";
import { _ as F } from "../../../../modules/factory-select-b8d0a4ac.js";
import { _ as H } from "../../../../modules/production-line-select-f08e245b.js";
import { u as K } from "../../../../modules/index-7da9f094.js";
import "../../../../modules/use-users-4d979987.js";
const M = { style: { float: "right" } }, $ = { class: "form" }, W = { __name: "form", setup(P) {
  const I = m(), p = m(), f = m(), c = m(), g = m(), h = { machineNumber: "", machineName: "", machineType: "", workshopInfId: "", factoryId: "", productionLineId: "", directorId: "", opcUrl: "", brand: "品牌", mac: "" }, k = R(() => d.status.edit >= 1), { crud: d, form: o, CRUD: s } = S(h, I), U = { machineNumber: [{ required: true, message: "请输入设备编号", trigger: "blur" }], machineName: [{ required: true, message: "请输入设备名称", trigger: "blur" }], machineType: [{ required: true, message: "请选择设备类型", trigger: "blur" }], factoryId: [{ required: true, message: "请选择工厂", trigger: "blur" }], productionLineId: [{ required: true, message: "请选择生产线", trigger: "blur" }], workshopInfId: [{ required: true, message: "请选择车间", trigger: "blur" }], mac: [{ required: true, message: "请输入MAC地址", trigger: "blur" }], opcUrl: [{ required: true, message: "请输入工控机地址", trigger: "blur" }], directorId: [{ required: true, message: "请选择负责人", trigger: "blur" }] };
  function w(u) {
    console.log(u);
  }
  function v() {
    d.form.workshopInfId = void 0, d.form.productionLineId = void 0;
  }
  return s.HOOK.afterToEdit = (u, l) => {
    console.log(l);
  }, s.HOOK.beforeToQuery = async () => {
  }, s.HOOK.beforeToEdit = () => {
    console.log(o);
  }, s.HOOK.beforeSubmit = async () => {
    var u;
    console.log(p.value.factories), o.factory = p.value.getOption(o.factoryId).name, console.log(f.value.workshops), o.workshopInf = f.value.getOption(o.workshopInfId).name, console.log(c.value.onlyProductLines), o.productionLine = c.value.getOption(o.productionLineId).name, console.log(g.value.users), o.director = (u = g.value.users.find((l) => l.id === o.directorId)) == null ? void 0 : u.name;
  }, (u, l) => {
    const y = b("common-button"), i = x, n = q, C = b("common-select"), T = E, N = b("common-dialog");
    return O(), L(N, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(d).cancelCU, visible: e(d).status.cu > 0, title: e(d).status.title, "show-close": false, width: "30%", top: "10vh" }, { titleRight: t(() => [_("span", M, [r(y, { loading: e(d).status.cu === e(s).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(d).submitCU }, { default: t(() => l[10] || (l[10] = [V(" 提 交 ")])), _: 1, __: [10] }, 8, ["loading", "onClick"]), r(e(z), { type: "crud" }), r(y, { size: "default", onClick: e(d).cancelCU }, { default: t(() => l[11] || (l[11] = [V("关 闭")])), _: 1, __: [11] }, 8, ["onClick"])])]), default: t(() => [_("div", $, [r(T, { ref_key: "formRef", ref: I, model: e(o), rules: U, size: "default", "label-width": "100px", class: "demo-form" }, { default: t(() => [r(n, { label: "设备编号：", prop: "machineNumber" }, { default: t(() => [r(i, { ref: "saveTagInput", modelValue: e(o).machineNumber, "onUpdate:modelValue": l[0] || (l[0] = (a) => e(o).machineNumber = a), class: "input-underline", placeholder: "输入设备编号" }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "设备类型：", prop: "machineType" }, { default: t(() => [r(C, { ref: "machineTypeRef", type: "enum", modelValue: e(o).machineType, "onUpdate:modelValue": l[1] || (l[1] = (a) => e(o).machineType = a), options: e(A).ENUM, clearable: "", placeholder: "请选择设备类型", style: { width: "270px" }, class: "filter-item", onChange: w }, null, 8, ["modelValue", "options"])]), _: 1 }), r(n, { label: "设备名称：", prop: "machineName" }, { default: t(() => [r(i, { ref: "saveTagInput", modelValue: e(o).machineName, "onUpdate:modelValue": l[2] || (l[2] = (a) => e(o).machineName = a), class: "input-underline", placeholder: "输入设备名称" }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "设备品牌：", prop: "brand" }, { default: t(() => [r(i, { ref: "saveTagInput", modelValue: e(o).brand, "onUpdate:modelValue": l[3] || (l[3] = (a) => e(o).brand = a), class: "input-underline", placeholder: "输入设备品牌" }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "所属工厂：", prop: "factoryId" }, { default: t(() => [r(F, { ref_key: "factoryRef", ref: p, modelValue: e(o).factoryId, "onUpdate:modelValue": l[4] || (l[4] = (a) => e(o).factoryId = a), placeholder: "请选择工厂", style: { width: "270px" }, onChange: v }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "所属车间：", prop: "workshopInfId" }, { default: t(() => [r(B, { ref_key: "workshopInfRef", ref: f, modelValue: e(o).workshopInfId, "onUpdate:modelValue": l[5] || (l[5] = (a) => e(o).workshopInfId = a), placeholder: "请先选择车间", "factory-id": e(o).factoryId, style: { width: "270px" }, defaultValue: "" }, null, 8, ["modelValue", "factory-id"])]), _: 1 }), r(n, { label: "生产线：", prop: "productionLineId" }, { default: t(() => [r(e(H), { ref_key: "productionLineRef", ref: c, modelValue: e(o).productionLineId, "onUpdate:modelValue": l[6] || (l[6] = (a) => e(o).productionLineId = a), "factory-id": e(o).factoryId, placeholder: "请先选择生产线", style: { width: "270px" }, defaultValue: "" }, null, 8, ["modelValue", "factory-id"])]), _: 1 }), r(n, { label: "负责人：", prop: "directorId" }, { default: t(() => [r(e(K), { ref_key: "userRef", ref: g, modelValue: e(o).directorId, "onUpdate:modelValue": l[7] || (l[7] = (a) => e(o).directorId = a), placeholder: "请选择负责人", style: { width: "270px" }, defaultValue: "" }, null, 8, ["modelValue"])]), _: 1 }), r(n, { label: "MAC地址：", prop: "mac" }, { default: t(() => [r(i, { ref: "saveTagInput", disabled: k.value, modelValue: e(o).mac, "onUpdate:modelValue": l[8] || (l[8] = (a) => e(o).mac = a), class: "input-underline", placeholder: "输入MAC地址" }, null, 8, ["disabled", "modelValue"])]), _: 1 }), r(n, { label: "工控机地址", prop: "opcUrl" }, { default: t(() => [r(i, { ref: "saveTagInput", modelValue: e(o).opcUrl, "onUpdate:modelValue": l[9] || (l[9] = (a) => e(o).opcUrl = a), class: "input-underline", placeholder: "输入工控机地址" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  W as default
};
