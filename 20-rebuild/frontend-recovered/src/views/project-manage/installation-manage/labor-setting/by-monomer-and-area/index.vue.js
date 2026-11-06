import { ref as I } from "vue";
import { watch as Z } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as i } from "vue";
import { createVNode as x } from "vue";
import { unref as s } from "vue";
import { withDirectives as R } from "vue";
import { createBlock as p } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as h } from "vue";
import { Fragment as g } from "vue";
import { renderList as L } from "vue";
import { createElementVNode as T } from "vue";
import { normalizeClass as b } from "vue";
import { normalizeStyle as k } from "vue";
import { toDisplayString as C } from "vue";
import { createTextVNode as O } from "vue";
import { ElMessage as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElDatePicker as ae } from "element-plus";
import { vLoading as oe } from "element-plus";
import { c as B } from "../../../../../modules/labor-setting-a0cbdb82.js";
import { _ as re, x as le, o as ie, kQ as u, K as $, D as z, p as q, G as se, i as ne } from "../../../../../shared/runtime.js";
import { u as H } from "../../../../../modules/project-19a12d6b.js";
import de from "./module/header.vue.js";
const ce = { key: 1, class: "sandwich-cell-bottom" }, pe = { key: 1, class: "sandwich-cell-bottom" }, ue = { key: 1, class: "sandwich-cell-bottom" }, ye = { key: 1, class: "sandwich-cell-bottom" }, me = { key: 1 }, ge = { key: 1, class: "sandwich-cell-bottom" }, he = { key: 1 }, fe = { key: 1, class: "sandwich-cell-bottom" }, _e = { key: 1, class: "sandwich-cell-bottom" }, Le = { __name: "index", props: { globalProjectId: { type: Number, default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(D) {
  const f = D, G = { add: false, edit: false, del: false, download: false }, J = { key: "supplierId", label: "supplierName", value: "supplierId" }, M = I(), V = I({}), P = I(false), j = I(false), { crud: y, columns: _, CRUD: S } = le({ title: "劳务设置", sort: ["id.desc"], permission: { ...H }, optShow: { ...G }, requiredQuery: ["projectId"], crudApi: { ...B }, hasPagination: false }, M), { maxHeight: K } = ie({ wrapperBox: ".subcontract-plan", paginate: true, extraHeight: 100 });
  Z(() => f.globalProjectId, (r) => {
    var l, d;
    r && (console.log(r, "val"), y.query.projectId = f.globalProjectId, y.query.monomerId = void 0, (l = f.globalProject) != null && l.installDivideMethod && ((d = f.globalProject) == null ? void 0 : d.installDivideMethod) === 1 && y.toQuery());
  }, { immediate: true }), S.HOOK.beforeRefresh = () => (y.query.projectId = f.globalProjectId || void 0, !!y.query.projectId);
  function Q(r, l) {
    const d = r.productTypeList[l].supplierId ? r.productTypeList.find((n) => n.supplierId === r.productTypeList[l].supplierId) : {};
    r.productTypeList[l].supplierName = r.productTypeList[l].supplierId ? d.supplierName : void 0;
  }
  function Y(r) {
    r.installStartDate = r.timeArr[0], r.installEndDate = r.timeArr[1];
  }
  function F(r, l) {
    V.value = JSON.parse(JSON.stringify(r.productTypeList[l])), r.productTypeList[l].isModify = true, P.value = true;
  }
  function X(r, l) {
    r.productTypeList[l] = Object.assign(r.productTypeList[l], JSON.parse(JSON.stringify(V.value))), r.productTypeList[l].isModify = false, P.value = false;
  }
  async function W(r, l) {
    if (!ne(r.productTypeList[l].timeArr) || !r.productTypeList[l].supplierId) {
      ee.error("分包单位和安装计划必填");
      return;
    }
    j.value = true;
    try {
      const d = { endDate: r.productTypeList[l].timeArr[1], id: r.productTypeList[l].id, startDate: r.productTypeList[l].timeArr[0], supplierId: r.productTypeList[l].supplierId };
      await B.edit(d), y.notify("修改成功", S.NOTIFICATION_TYPE.SUCCESS), r.productTypeList[l].isModify = false, y.toQuery(), P.value = false;
    } catch (d) {
      console.log("修改", d);
    } finally {
      j.value = false;
    }
  }
  return S.HOOK.handleRefresh = (r, l) => {
    var d;
    (d = l.data.content) == null || d.forEach((n, U) => {
      var w, E, v, t, e, c;
      n.map = /* @__PURE__ */ new Map(), n.productTypeMap = {}, (w = n.manageAreaList) == null || w.forEach((o) => {
        o.unit = o.projectPlanProductCategory === u.STRUCTURE.V || f.globalProject.projectType === $.BRIDGE.V ? "t" : "m", o.decimal = o.projectPlanProductCategory === u.STRUCTURE.V || f.globalProject.projectType === $.BRIDGE.V ? z.COM_WT__KG : z.MES_ENCLOSURE_L__M;
      }), n.structureList = (E = n.manageAreaList) == null ? void 0 : E.filter((o) => o.projectPlanProductCategory === u.STRUCTURE.V), n.enclosureList = (v = n.manageAreaList) == null ? void 0 : v.filter((o) => o.projectPlanProductCategory === u.ENCLOSURE.V), n.auxiliaryList = (t = n.manageAreaList) == null ? void 0 : t.filter((o) => o.projectPlanProductCategory === u.AUXILIARY_MATERIAL.V), n.productTypeList = [...n.structureList, ...n.enclosureList, ...n.auxiliaryList], (e = n.productTypeList) == null || e.forEach((o) => {
        o.imeArr = [], o.installStartDate && o.installEndDate && (o.timeArr = [o.installStartDate, o.installEndDate]);
      }), n.productTypeMap = (c = n.productTypeList) == null ? void 0 : c.filter((o) => !n.map.has(o.projectPlanProductCategory) && n.map.set(o.projectPlanProductCategory, o));
    });
  }, (r, l) => {
    const d = te, n = A("common-select"), U = ae, w = A("common-button"), E = A("common-table"), v = oe;
    return a(), i("div", null, [x(s(de)), R((a(), p(E, { ref_key: "tableRef", ref: M, data: s(y).data, "empty-text": s(y).emptyText, "max-height": s(K), "return-source-data": "", showEmptySymbol: false, stripe: false, class: "upload-table", style: { width: "100%", "margin-top": "10px" } }, { default: m(() => [s(_).visible("name") ? (a(), p(d, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "单体" })) : h("", true), s(_).visible("content") ? (a(), p(d, { key: "content", prop: "content", label: "类别", align: "center" }, { default: m((t) => [t.row.productTypeMap.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeMap, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeMap.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top"), style: k(`height: ${e.projectPlanProductCategory === s(u).STRUCTURE.V ? t.row.structureList.length * 40 : e.projectPlanProductCategory === s(u).ENCLOSURE.V ? t.row.enclosureList.length * 40 : e.projectPlanProductCategory === s(u).AUXILIARY_MATERIAL.V ? t.row.auxiliaryList.length * 40 : 40}px; line-height: ${e.projectPlanProductCategory === s(u).STRUCTURE.V ? t.row.structureList.length * 30 + 10 : e.projectPlanProductCategory === s(u).ENCLOSURE.V ? t.row.enclosureList.length * 30 + 10 : e.projectPlanProductCategory === s(u).AUXILIARY_MATERIAL.V ? t.row.auxiliaryList.length * 30 + 10 : 30}px`) }, C(e.projectPlanProductCategory ? s(u).VL[e.projectPlanProductCategory] : "-"), 7)]))), 128)) : (a(), i("div", ce, "-"))]), _: 1 })) : h("", true), s(_).visible("unit") ? (a(), p(d, { key: "unit", prop: "unit", label: "区域", align: "center" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, C(e.name), 3)]))), 128)) : (a(), i("div", pe, "-"))]), _: 1 })) : h("", true), s(_).visible("unit") ? (a(), p(d, { key: "unit", prop: "unit", label: "单位", align: "center" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, C(e.unit), 3)]))), 128)) : (a(), i("div", ue, "-"))]), _: 1 })) : h("", true), s(_).visible("deepenMete") ? (a(), p(d, { key: "deepenMete", prop: "deepenMete", label: "清单量", align: "center" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, C(e.deepenMete), 3)]))), 128)) : (a(), i("div", ye, "-"))]), _: 1 })) : h("", true), s(_).visible("areaList") ? (a(), p(d, { key: "areaList", prop: "areaList", label: "分包单位", align: "center", "min-width": "140" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), p(n, { key: 0, modelValue: e.supplierId, "onUpdate:modelValue": (o) => e.supplierId = o, options: t.row.supplierList, type: "other", size: "default", class: "input-underline", dataStructure: J, clearable: "", placeholder: "分包单位", onChange: (o) => Q(t.row, c) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (a(), i("span", me, C(e.supplierName || "-"), 1))], 2)]))), 128)) : (a(), i("div", ge, "-"))]), _: 1 })) : h("", true), s(_).visible("install") ? (a(), p(d, { key: "install", prop: "install", label: "完成日期", align: "center", "min-width": "150" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), p(U, { key: 0, modelValue: e.timeArr, "onUpdate:modelValue": (o) => e.timeArr = o, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", style: { width: "100%" }, disabledDate: (o) => {
      var N;
      return o.getTime() > ((N = D.globalProject) == null ? void 0 : N.endDate);
    }, onChange: (o) => Y(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "onChange"])) : (a(), i("span", he, C(e != null && e.installStartDate && (e != null && e.installEndDate) ? s(q)(e == null ? void 0 : e.installStartDate, "{y}-{m}-{d}") + " : " + s(q)(e == null ? void 0 : e.installEndDate, "{y}-{m}-{d}") : "-"), 1))], 2)]))), 128)) : (a(), i("div", fe, "-"))]), _: 1 })) : h("", true), x(d, { label: "操作", width: "160px", align: "center", fixed: "right" }, { default: m((t) => [t.row.productTypeList.length > 0 ? (a(true), i(g, { key: 0 }, L(t.row.productTypeList, (e, c) => (a(), i("div", { key: e.id }, [T("div", { class: b(c === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), i(g, { key: 0 }, [R((a(), p(w, { type: "info", size: "default", onClick: (o) => X(t.row, c) }, { default: m(() => l[0] || (l[0] = [O("取消")])), _: 2, __: [0] }, 1032, ["onClick"])), [[v, j.value]]), R((a(), p(w, { type: "primary", size: "default", onClick: (o) => W(t.row, c) }, { default: m(() => l[1] || (l[1] = [O(" 保存 ")])), _: 2, __: [1] }, 1032, ["onClick"])), [[v, j.value]])], 64)) : (a(), i(g, { key: 1 }, [s(se)(s(H).edit) ? (a(), p(w, { key: 0, size: "default", onClick: (o) => F(t.row, c), icon: "el-icon-edit", type: "primary", disabled: P.value }, null, 8, ["onClick", "disabled"])) : h("", true)], 64))], 2)]))), 128)) : (a(), i("div", _e))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[v, s(y).loading]])]);
  };
} }, Pe = re(Le, [["__scopeId", "data-v-0383aac5"]]);
export {
  Pe as default
};
