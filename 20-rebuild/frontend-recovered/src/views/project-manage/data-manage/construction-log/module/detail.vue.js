import { ref as _ } from "vue";
import { watch as Y } from "vue";
import { nextTick as H } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as n } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as w } from "vue";
import { unref as f } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as D } from "vue";
import { createVNode as o } from "vue";
import { toDisplayString as i } from "vue";
import { createElementBlock as v } from "vue";
import { isRef as K } from "vue";
import Q from "moment";
import { ElNotification as X } from "element-plus";
import { ElFormItem as Z } from "element-plus";
import { ElCol as ee } from "element-plus";
import { ElRow as te } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElForm as oe } from "element-plus";
import { l as x, u as ne, i as re, bC as se, G as E, L as ue, cy as N, aw as ie } from "../../../../../shared/runtime.js";
import { a as T } from "../../../../../modules/project-19a12d6b.js";
function de(s) {
  return x({ module: "project", url: "construction-log", method: "get", params: s });
}
function me(s) {
  return x({ module: "project", url: "construction-log", method: "post", data: s });
}
function pe(s) {
  return x({ module: "project", url: "construction-log", method: "put", data: s });
}
function ce(s) {
  return x({ module: "project", url: "construction-log/export", method: "get", params: s, responseType: "blob" });
}
const q = { get: de, add: me, edit: pe }, fe = { class: "dialog-title flex-rbc" }, ve = { class: "dialog-container" }, ye = { key: 1 }, we = { key: 1 }, ge = { key: 1 }, be = { key: 1 }, ke = { key: 1 }, he = { key: 1 }, Ve = { key: 1 }, _e = { key: 1 }, De = { key: 1 }, xe = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, info: { type: Object, default: () => {
} }, day: { type: String, default: "" }, activeMonth: { type: [String, Number], default: void 0 }, projectId: { type: [String, Number], default: void 0 } }, emits: ["success", "update:modelValue"], setup(s, { emit: S }) {
  const y = s, M = { links: [], afternoonTemperature: void 0, afternoonWeather: void 0, afternoonWind: void 0, constructionDate: void 0, constructionDesc: void 0, existingProblemDesc: void 0, groupWorkDesc: void 0, id: void 0, machineWorkDesc: void 0, managerId: void 0, morningTemperature: void 0, morningWeather: void 0, morningWind: void 0, projectId: void 0, qualityInspectionDesc: void 0, recorderId: void 0, safetyInspectionDesc: void 0, siteImportantEvent: void 0 }, e = _(JSON.parse(JSON.stringify(M))), b = _(), I = _(false), O = { managerId: [{ required: true, message: "请选择负责人", trigger: "change" }], recorderId: [{ required: true, message: "请选择记录人", trigger: "change" }] }, r = _(true), U = S, { visible: h, handleClose: W } = ne({ emit: U, props: y }), P = { weather: [{ required: true, message: "请输入天气", trigger: "blur" }], wind: [{ required: true, message: "请输入风力", trigger: "blur" }], temperature: [{ required: true, message: "请输入温度", trigger: "blur" }] }, { tableValidate: B, wrongCellMask: F } = ie({ rules: P });
  Y(() => h.value, (p) => {
    p && (re(y.info) ? (j(y.info), r.value = false) : (j(), r.value = true));
  });
  function j(p) {
    b.value && b.value.resetFields(), p && Object.keys(p).length > 0 ? (e.value = p, e.value.links = [{ time: "上午", temperature: e.value.morningTemperature, weather: e.value.morningWeather, wind: e.value.morningWind }, { time: "下午", temperature: e.value.afternoonTemperature, weather: e.value.afternoonWeather, wind: e.value.afternoonWind }]) : (e.value = JSON.parse(JSON.stringify(M)), e.value.links = [{ time: "上午" }, { time: "下午" }]), b.value && H(() => {
      b.value.clearValidate();
    }), se(b, e);
  }
  function J() {
    U("success");
  }
  async function L() {
    const { validResult: p, dealList: t } = B(e.value.links);
    if (p) e.value.links = t;
    else return p;
    try {
      I.value = true;
      const c = { ...e.value, afternoonTemperature: e.value.links[1].temperature, afternoonWeather: e.value.links[1].weather, afternoonWind: e.value.links[1].wind, morningTemperature: e.value.links[0].temperature, morningWeather: e.value.links[0].weather, morningWind: e.value.links[0].wind, projectId: y.projectId, constructionDate: Q(y.day).valueOf() };
      y.info.id ? await q.edit(c) : await q.add(c), X({ title: y.info.id ? "修改成功" : "添加成功", type: "success", duration: 2500 }), W(), J();
    } catch (c) {
      console.log("添加施工日志: ", c);
    } finally {
      I.value = false;
    }
  }
  return (p, t) => {
    const c = z("common-button"), d = Z, R = ee, C = te, V = le, m = ae, $ = z("common-table"), A = oe, G = z("common-drawer");
    return n(), u(G, { modelValue: f(h), "onUpdate:modelValue": t[11] || (t[11] = (l) => K(h) ? h.value = l : null), size: "50%", "show-close": false, "before-close": f(W) }, { title: a(() => [w("div", fe, [t[17] || (t[17] = w("div", { class: "title" }, [w("span", null, "施工日志")], -1)), w("div", null, [f(E)(f(T).download) && !r.value ? (n(), u(ue, { key: 0, params: { yearMonth: s.activeMonth, projectId: s.projectId, day: new Date(s.day).getDate() < 10 ? "0" + new Date(s.day).getDate() : new Date(s.day).getDate() }, fn: f(ce) }, { default: a(() => t[12] || (t[12] = [g("下载施工日志")])), _: 1, __: [12] }, 8, ["params", "fn"])) : D("", true), s.info.id && r.value ? (n(), u(c, { key: 1, size: "default", onClick: t[0] || (t[0] = (l) => r.value = false) }, { default: a(() => t[13] || (t[13] = [g("取消")])), _: 1, __: [13] })) : D("", true), r.value ? (n(), u(c, { key: 2, loading: I.value, type: "primary", size: "default", onClick: L }, { default: a(() => t[14] || (t[14] = [g("提交")])), _: 1, __: [14] }, 8, ["loading"])) : D("", true), f(E)(f(T).add) && !r.value ? (n(), u(c, { key: 3, size: "default", onClick: t[1] || (t[1] = (l) => r.value = true), type: "primary" }, { default: a(() => t[15] || (t[15] = [g("修改")])), _: 1, __: [15] })) : D("", true), o(c, { size: "default", onClick: f(W) }, { default: a(() => t[16] || (t[16] = [g("关闭")])), _: 1, __: [16] }, 8, ["onClick"])])])]), content: a(() => [w("div", ve, [o(A, { ref_key: "formRef", ref: b, model: e.value, rules: O, size: "default", "label-position": "left", "label-width": "120px" }, { default: a(() => [o(C, { gutter: 40 }, { default: a(() => [o(R, { span: 11 }, { default: a(() => [o(d, { label: "日期" }, { default: a(() => [w("span", null, i(s.day), 1)]), _: 1 })]), _: 1 })]), _: 1 }), o($, { ref: "detailRef", border: "", data: e.value.links, style: { width: "100%", "margin-bottom": "30px" }, class: "table-form", "return-source-data": "", showEmptySymbol: false, "cell-class-name": f(F) }, { default: a(() => [o(V, { key: "keyword", prop: "keyword", label: "时间", align: "center" }, { default: a((l) => [w("span", null, i(l.row.time), 1)]), _: 1 }), o(V, { key: "weather", prop: "weather", label: "天气情况", align: "center" }, { default: a((l) => [o(m, { modelValue: l.row.weather, "onUpdate:modelValue": (k) => l.row.weather = k, modelModifiers: { trim: true }, placeholder: "天气情况", maxlength: "10", size: "default", class: "input-underline", style: { width: "100%" }, disabled: !r.value }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), o(V, { key: "wind", prop: "wind", label: "风力", align: "center" }, { default: a((l) => [o(m, { modelValue: l.row.wind, "onUpdate:modelValue": (k) => l.row.wind = k, modelModifiers: { trim: true }, placeholder: "风力", maxlength: "6", size: "default", class: "input-underline", disabled: !r.value, style: { width: "100%" } }, { suffix: a(() => t[18] || (t[18] = [g("级")])), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), o(V, { key: "temperature", prop: "temperature", label: "温度", align: "center" }, { default: a((l) => [o(m, { modelValue: l.row.temperature, "onUpdate:modelValue": (k) => l.row.temperature = k, modelModifiers: { trim: true }, placeholder: "温度", maxlength: "5", size: "default", disabled: !r.value, class: "input-underline", style: { width: "100%" } }, { suffix: a(() => t[19] || (t[19] = [g("℃")])), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"]), o(d, { label: "施工部分描述", prop: "constructionDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.constructionDesc, "onUpdate:modelValue": t[2] || (t[2] = (l) => e.value.constructionDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "施工部分描述", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", ye, i(e.value.constructionDesc), 1))]), _: 1 }), o(d, { label: "机械作业描述", prop: "machineWorkDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.machineWorkDesc, "onUpdate:modelValue": t[3] || (t[3] = (l) => e.value.machineWorkDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "机械作业描述", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", we, i(e.value.machineWorkDesc), 1))]), _: 1 }), o(d, { label: "班组上岗情况", prop: "groupWorkDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.groupWorkDesc, "onUpdate:modelValue": t[4] || (t[4] = (l) => e.value.groupWorkDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "班组上岗情况", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", ge, i(e.value.groupWorkDesc), 1))]), _: 1 }), o(d, { label: "质量检查情况", prop: "qualityInspectionDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.qualityInspectionDesc, "onUpdate:modelValue": t[5] || (t[5] = (l) => e.value.qualityInspectionDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "质量检查情况", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", be, i(e.value.qualityInspectionDesc), 1))]), _: 1 }), o(d, { label: "安全检查情况", prop: "safetyInspectionDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.safetyInspectionDesc, "onUpdate:modelValue": t[6] || (t[6] = (l) => e.value.safetyInspectionDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "安全检查情况", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", ke, i(e.value.safetyInspectionDesc), 1))]), _: 1 }), o(d, { label: "工地重大事件", prop: "siteImportantEvent" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.siteImportantEvent, "onUpdate:modelValue": t[7] || (t[7] = (l) => e.value.siteImportantEvent = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "工地重大事件", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", he, i(e.value.siteImportantEvent), 1))]), _: 1 }), o(d, { label: "存在问题描述", prop: "existingProblemDesc" }, { default: a(() => [r.value ? (n(), u(m, { key: 0, modelValue: e.value.existingProblemDesc, "onUpdate:modelValue": t[8] || (t[8] = (l) => e.value.existingProblemDesc = l), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "存在问题描述", style: { width: "90%" }, "show-word-limit": "", maxlength: "255" }, null, 8, ["modelValue"])) : (n(), v("span", Ve, i(e.value.existingProblemDesc), 1))]), _: 1 }), o(C, { gutter: 40 }, { default: a(() => [o(R, { span: 11 }, { default: a(() => [o(d, { label: "负责人", prop: "managerId" }, { default: a(() => [r.value ? (n(), u(N, { key: 0, modelValue: e.value.managerId, "onUpdate:modelValue": t[9] || (t[9] = (l) => e.value.managerId = l), filterable: "", clearable: "", "show-all-levels": "", placeholder: "负责人", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue"])) : (n(), v("span", _e, i(e.value.managerName), 1))]), _: 1 })]), _: 1 }), o(R, { span: 11 }, { default: a(() => [o(d, { label: "记录人", prop: "recorderId" }, { default: a(() => [r.value ? (n(), u(N, { key: 0, modelValue: e.value.recorderId, "onUpdate:modelValue": t[10] || (t[10] = (l) => e.value.recorderId = l), filterable: "", clearable: "", "show-all-levels": "", placeholder: "记录人", style: { width: "100%" }, class: "input-underline" }, null, 8, ["modelValue"])) : (n(), v("span", De, i(e.value.recorderName), 1))]), _: 1 })]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ze = Object.freeze(Object.defineProperty({ __proto__: null, default: xe }, Symbol.toStringTag, { value: "Module" }));
export {
  xe as _,
  ze as a,
  q as c,
  ce as d
};
