import { ref as P } from "vue";
import { watch as B } from "vue";
import { ElMessage as U } from "element-plus";
import { resolveComponent as x } from "vue";
import { openBlock as y } from "vue";
import { createBlock as F } from "vue";
import { withCtx as i } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as I } from "vue";
import { createElementBlock as h } from "vue";
import { Fragment as L } from "vue";
import { renderList as R } from "vue";
import { ElInput as K } from "element-plus";
import { ElFormItem as N } from "element-plus";
import { ElDatePicker as M } from "element-plus";
import { ElInputNumber as z } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as A, ao as G, i as H, T as W, D as V } from "../../../../../shared/runtime.js";
const $ = { class: "form-row", style: { display: "flex" } }, J = { __name: "form", props: { projectId: { type: [Number, String], default: void 0 }, originOption: { type: Array, default: () => [] }, globalProject: { type: Object, default: () => {
} } }, setup(c) {
  const D = P(), g = P([]), s = c, w = { id: void 0, projectId: void 0, name: "", date: void 0, sort: 1, remark: "", battenBoard: void 0, battenBoardDate: void 0, contourPlate: void 0, contourPlateDate: void 0, flangingPiece: void 0, flangingPieceDate: void 0, mainStructure: void 0, mainStructureDate: void 0, pressureBearingPlate: void 0, pressureBearingPlateDate: void 0, subStructure: void 0, subStructureDate: void 0, trussFloorPlate: void 0, trussFloorPlateDate: void 0, detailSaveDTOParamList: void 0 }, { CRUD: T, crud: a, form: r } = G(w, D), k = (l, e, n) => {
    e ? s.globalProject.endDate && e > s.globalProject.endDate ? n(new Error("不能超过项目完成时间")) : n() : n(new Error("请选择完成日期"));
  }, m = (l, e, n) => {
    e && (a.form.date && e > a.form.date ? n(new Error("不能超过单体完成时间")) : n()), n();
  }, j = { startDate: [{ required: true, message: "请选择开始时间", trigger: "change" }], date: [{ validator: k, trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], battenBoard: [{ message: "请填写", trigger: "blur", type: "number" }], battenBoardDate: [{ validator: m, trigger: "change" }], contourPlate: [{ message: "请填写", trigger: "blur", type: "number" }], contourPlateDate: [{ validator: m, trigger: "change" }], flangingPiece: [{ message: "请填写", trigger: "blur", type: "number" }], flangingPieceDate: [{ validator: m, trigger: "change" }], mainStructure: [{ message: "请填写", trigger: "blur", type: "number" }], mainStructureDate: [{ validator: m, trigger: "change" }], pressureBearingPlate: [{ message: "请填写", trigger: "blur", type: "number" }], pressureBearingPlateDate: [{ validator: m, trigger: "change" }], subStructure: [{ message: "请填写", trigger: "blur", type: "number" }], subStructureDate: [{ validator: m, trigger: "change" }], trussFloorPlate: [{ message: "请填写", trigger: "blur", type: "number" }], trussFloorPlateDate: [{ validator: m, trigger: "change" }], name: [{ required: true, message: "请填写单体名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  B(() => s.globalProject, (l) => {
    H(l) && (g.value = [], s.originOption.forEach((e) => {
      l.projectContentList.findIndex((n) => n.no === e.no) > -1 && g.value.push(e);
    }));
  }, { deep: true, immediate: true });
  function v(l) {
    return a.form.date ? l.getTime() > a.form.date || l.getTime() < s.globalProject.startDate : l.getTime() - 864e4 > s.globalProject.endDate || l.getTime() < s.globalProject.startDate;
  }
  function S(l) {
    return a.form.startDate ? l.getTime() - 864e4 > s.globalProject.endDate || l.getTime() < a.form.startDate : l.getTime() - 864e4 > s.globalProject.endDate || l.getTime() < s.globalProject.startDate;
  }
  return T.HOOK.beforeSubmit = () => {
    a.form.detailSaveDTOParamList = [], g.value.forEach((e) => {
      let n;
      a.form.id && (n = a.form.monomerDetailList.find((f) => f.type === e.no)), a.form[e.key] && (n ? (n.mete = a.form[e.key], n.date = a.form[e.dateKey], a.form.detailSaveDTOParamList.push(n)) : a.form.detailSaveDTOParamList.push({ mete: a.form[e.key], date: a.form[e.dateKey], type: e.no }));
    });
    let l = true;
    return a.form.detailSaveDTOParamList.map((e) => {
      e.date || (l = false);
    }), l ? (a.form.projectId = s.projectId, !!a.form.projectId) : (U.error("完成日期必填"), false);
  }, (l, e) => {
    const n = x("common-button"), f = K, p = N, b = M, _ = z, E = q, O = x("common-dialog");
    return y(), F(O, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(a).cancelCU, visible: t(a).status.cu > 0, title: t(a).status.title, width: "1000px" }, { titleRight: i(() => [d(n, { loading: t(a).status.cu === 2, type: "primary", size: "default", onClick: t(a).submitCU }, { default: i(() => e[6] || (e[6] = [C("确认")])), _: 1, __: [6] }, 8, ["loading", "onClick"])]), default: i(() => [d(E, { ref_key: "formRef", ref: D, model: t(r), rules: j, size: "default", "label-width": "120px" }, { default: i(() => [I("div", $, [d(p, { label: "单体名称", prop: "name" }, { default: i(() => [d(f, { modelValue: t(r).name, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(r).name = o), type: "text", placeholder: "请填写单体名称", style: { width: "270px" }, onBlur: e[1] || (e[1] = (o) => t(r).name = t(r).name.replace(/[ ]/g, "")) }, null, 8, ["modelValue"])]), _: 1 }), d(p, { "label-width": "5px", prop: "startDate" }, { default: i(() => [d(b, { modelValue: t(r).startDate, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(r).startDate = o), type: "date", "value-format": "x", placeholder: "选择开始日期", style: { width: "160px" }, disabledDate: v }, null, 8, ["modelValue"])]), _: 1 }), d(p, { "label-width": "5px", prop: "date" }, { default: i(() => [d(b, { modelValue: t(r).date, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(r).date = o), type: "date", "value-format": "x", placeholder: "选择完成日期", style: { width: "160px" }, disabledDate: S }, null, 8, ["modelValue"])]), _: 1 })]), (y(true), h(L, null, R(g.value, (o) => (y(), h("div", { key: o.key, class: "form-row", style: { display: "flex" } }, [d(p, { label: o.label + "(" + o.unit + ")", prop: o.key }, { default: i(() => [d(_, { modelValue: t(r)[o.key], "onUpdate:modelValue": (u) => t(r)[o.key] = u, step: 10, min: 0, max: 999999999999, precision: o.no === t(W).STRUCTURE.V ? t(V).COM_WT__KG : t(V).MES_ENCLOSURE_L__M, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 2 }, 1032, ["label", "prop"]), d(p, { "label-width": "5px", prop: o.dateKey }, { default: i(() => [d(b, { modelValue: t(r)[o.dateKey], "onUpdate:modelValue": (u) => t(r)[o.dateKey] = u, type: "date", "value-format": "x", placeholder: "选择完成日期", style: { width: "160px" }, disabledDate: (u) => (t(r).startDate ? u.getTime() < t(r).startDate : u.getTime() < c.globalProject.startDate) || (t(r).date ? u.getTime() > t(r).date : u.getTime() > c.globalProject.endDate), disabled: !t(r)[o.key] }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "disabled"])]), _: 2 }, 1032, ["prop"])]))), 128)), d(p, { label: "排序", prop: "sort" }, { default: i(() => [d(_, { modelValue: t(r).sort, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(r).sort = o), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), d(p, { label: "备注", prop: "remark" }, { default: i(() => [d(f, { modelValue: t(r).remark, "onUpdate:modelValue": e[5] || (e[5] = (o) => t(r).remark = o), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", maxlength: 200, "show-word-limit": "", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Y = A(J, [["__scopeId", "data-v-568b53fe"]]);
export {
  Y as default
};
