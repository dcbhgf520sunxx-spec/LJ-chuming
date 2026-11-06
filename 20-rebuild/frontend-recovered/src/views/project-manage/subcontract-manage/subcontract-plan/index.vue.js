import { ref as R } from "vue";
import { watch as te } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as l } from "vue";
import { unref as i } from "vue";
import { createVNode as M } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as c } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as _ } from "vue";
import { Fragment as h } from "vue";
import { renderList as f } from "vue";
import { createElementVNode as L } from "vue";
import { normalizeClass as T } from "vue";
import { normalizeStyle as ae } from "vue";
import { toDisplayString as v } from "vue";
import { createTextVNode as U } from "vue";
import { ElMessage as oe } from "element-plus";
import { ElTableColumn as re } from "element-plus";
import { ElDatePicker as le } from "element-plus";
import { ElTag as ie } from "element-plus";
import { vLoading as se } from "element-plus";
import { c as $ } from "../../../../modules/subcontract-plan-b05fc818.js";
import { _ as ne, m as de, x as ce, o as pe, bN as q, kQ as p, K as G, D as H, p as J, G as ue, i as ye } from "../../../../shared/runtime.js";
import { M as K } from "../../../../modules/project-19a12d6b.js";
import me from "./module/header.vue.js";
import "./module/subcontract-account.vue.js";
const he = { class: "app-container" }, _e = { key: 0 }, ge = { key: 1, class: "sandwich-cell-bottom" }, fe = { key: 1, class: "sandwich-cell-bottom" }, Le = { key: 1, class: "sandwich-cell-bottom" }, Te = { key: 1, class: "sandwich-cell-bottom" }, be = { key: 1 }, we = { key: 1, class: "sandwich-cell-bottom" }, ve = { key: 1 }, Ce = { key: 1, class: "sandwich-cell-bottom" }, Pe = { key: 1, class: "sandwich-cell-bottom" }, Ee = { key: 1 }, Ie = { __name: "index", setup(Ae) {
  const { globalProjectId: j, globalProject: C } = de(["globalProjectId", "globalProject"]), Q = { add: false, edit: false, del: false, download: false }, Y = { key: "supplierId", label: "supplierName", value: "supplierId" }, x = R(), O = R({}), E = R(false), I = R(false), { crud: y, columns: g, CRUD: V } = ce({ title: "分包工期制定", sort: ["id.desc"], permission: { ...K }, optShow: { ...Q }, requiredQuery: ["projectId"], crudApi: { ...$ }, hasPagination: false }, x), { maxHeight: F } = pe({ wrapperBox: ".subcontract-plan", paginate: true, extraHeight: 100 });
  te(() => j.value, (o) => {
    o && (y.query.projectId = j.value, y.query.monomerId = void 0, y.toQuery());
  }, { immediate: true, deep: true }), V.HOOK.beforeRefresh = () => (y.query.projectId = C.value.businessType === q.INSTALLATION.V ? j.value : void 0, !!y.query.projectId);
  function X(o, r) {
    const n = o.productTypeList[r].supplierId ? o.productTypeList.find((s) => s.supplierId === o.productTypeList[r].supplierId) : {};
    o.productTypeList[r].supplierName = o.productTypeList[r].supplierId ? n.supplierName : void 0;
  }
  function W(o) {
    o.installStartDate = o.timeArr[0], o.installEndDate = o.timeArr[1];
  }
  function Z(o, r) {
    O.value = JSON.parse(JSON.stringify(o.productTypeList[r])), o.productTypeList[r].isModify = true, E.value = true;
  }
  function k(o, r) {
    o.productTypeList[r] = Object.assign(o.productTypeList[r], JSON.parse(JSON.stringify(O.value))), o.productTypeList[r].isModify = false, E.value = false;
  }
  async function ee(o, r) {
    if (!ye(o.productTypeList[r].timeArr) || !o.productTypeList[r].supplierId) {
      oe.error("分包单位和安装计划必填");
      return;
    }
    I.value = true;
    try {
      const n = { endDate: o.productTypeList[r].timeArr[1], id: o.productTypeList[r].id, startDate: o.productTypeList[r].timeArr[0], supplierId: o.productTypeList[r].supplierId };
      await $.edit(n), y.notify("修改成功", V.NOTIFICATION_TYPE.SUCCESS), o.productTypeList[r].isModify = false, y.toQuery(), E.value = false;
    } catch (n) {
      console.log("修改", n);
    } finally {
      I.value = false;
    }
  }
  return V.HOOK.handleRefresh = (o, r) => {
    var n;
    (n = r.data.content) == null || n.forEach((s, z) => {
      var b, A, S, w, P, t;
      s.map = /* @__PURE__ */ new Map(), s.productTypeMap = {}, (b = s.manageAreaList) == null || b.forEach((e) => {
        e.unit = e.projectPlanProductCategory === p.STRUCTURE.V || C.value.projectType === G.BRIDGE.V ? "t" : "m", e.decimal = e.projectPlanProductCategory === p.STRUCTURE.V || C.value.projectType === G.BRIDGE.V ? H.COM_WT__KG : H.MES_ENCLOSURE_L__M;
      }), s.structureList = (A = s.manageAreaList) == null ? void 0 : A.filter((e) => e.projectPlanProductCategory === p.STRUCTURE.V), s.enclosureList = (S = s.manageAreaList) == null ? void 0 : S.filter((e) => e.projectPlanProductCategory === p.ENCLOSURE.V), s.auxiliaryList = (w = s.manageAreaList) == null ? void 0 : w.filter((e) => e.projectPlanProductCategory === p.AUXILIARY_MATERIAL.V), s.productTypeList = [...s.structureList, ...s.enclosureList, ...s.auxiliaryList], (P = s.productTypeList) == null || P.forEach((e) => {
        e.imeArr = [], e.installStartDate && e.installEndDate && (e.timeArr = [e.installStartDate, e.installEndDate]);
      }), s.productTypeMap = (t = s.productTypeList) == null ? void 0 : t.filter((e) => !s.map.has(e.projectPlanProductCategory) && s.map.set(e.projectPlanProductCategory, e)), console.log(s, "k");
    });
  }, (o, r) => {
    var P;
    const n = re, s = D("common-select"), z = le, b = D("common-button"), A = D("common-table"), S = ie, w = se;
    return a(), l("div", he, [((P = i(C)) == null ? void 0 : P.businessType) === i(q).INSTALLATION.V ? (a(), l("div", _e, [M(i(me)), N((a(), c(A, { ref_key: "tableRef", ref: x, data: i(y).data, "empty-text": i(y).emptyText, "max-height": i(F), "return-source-data": "", showEmptySymbol: false, stripe: false, class: "upload-table", style: { width: "100%", "margin-top": "10px" } }, { default: u(() => [i(g).visible("name") ? (a(), c(n, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "单体" })) : _("", true), i(g).visible("content") ? (a(), c(n, { key: "content", prop: "content", label: "类别", align: "center" }, { default: u((t) => [t.row.productTypeMap.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeMap, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeMap.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top"), style: ae(`height: ${e.projectPlanProductCategory === i(p).STRUCTURE.V ? t.row.structureList.length * 40 : e.projectPlanProductCategory === i(p).ENCLOSURE.V ? t.row.enclosureList.length * 40 : e.projectPlanProductCategory === i(p).AUXILIARY_MATERIAL.V ? t.row.auxiliaryList.length * 40 : 40}px; line-height: ${e.projectPlanProductCategory === i(p).STRUCTURE.V ? t.row.structureList.length * 30 + 10 : e.projectPlanProductCategory === i(p).ENCLOSURE.V ? t.row.enclosureList.length * 30 + 10 : e.projectPlanProductCategory === i(p).AUXILIARY_MATERIAL.V ? t.row.auxiliaryList.length * 30 + 10 : 30}px`) }, v(e.projectPlanProductCategory ? i(p).VL[e.projectPlanProductCategory] : "-"), 7)]))), 128)) : (a(), l("div", ge, "-"))]), _: 1 })) : _("", true), i(g).visible("unit") ? (a(), c(n, { key: "unit", prop: "unit", label: "区域", align: "center" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(e.name), 3)]))), 128)) : (a(), l("div", fe, "-"))]), _: 1 })) : _("", true), i(g).visible("unit") ? (a(), c(n, { key: "unit", prop: "unit", label: "单位", align: "center" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(e.unit), 3)]))), 128)) : (a(), l("div", Le, "-"))]), _: 1 })) : _("", true), i(g).visible("deepenMete") ? (a(), c(n, { key: "deepenMete", prop: "deepenMete", label: "清单量", align: "center" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, v(e.deepenMete), 3)]))), 128)) : (a(), l("div", Te, "-"))]), _: 1 })) : _("", true), i(g).visible("areaList") ? (a(), c(n, { key: "areaList", prop: "areaList", label: "分包单位", align: "center", "min-width": "140" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), c(s, { key: 0, modelValue: e.supplierId, "onUpdate:modelValue": (m) => e.supplierId = m, options: t.row.supplierList, type: "other", size: "default", class: "input-underline", dataStructure: Y, clearable: "", placeholder: "分包单位", onChange: (m) => X(t.row, d) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])) : (a(), l("span", be, v(e.supplierName || "-"), 1))], 2)]))), 128)) : (a(), l("div", we, "-"))]), _: 1 })) : _("", true), i(g).visible("install") ? (a(), c(n, { key: "install", prop: "install", label: "完成日期", align: "center", "min-width": "150" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), c(z, { key: 0, modelValue: e.timeArr, "onUpdate:modelValue": (m) => e.timeArr = m, type: "daterange", "range-separator": ":", size: "default", class: "date-item filter-item", "value-format": "x", "start-placeholder": "开始", "end-placeholder": "结束", style: { width: "100%" }, disabledDate: (m) => {
      var B;
      return m.getTime() > ((B = i(C)) == null ? void 0 : B.endDate);
    }, onChange: (m) => W(e) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "onChange"])) : (a(), l("span", ve, v(e != null && e.installStartDate && (e != null && e.installEndDate) ? i(J)(e == null ? void 0 : e.installStartDate, "{y}-{m}-{d}") + " : " + i(J)(e == null ? void 0 : e.installEndDate, "{y}-{m}-{d}") : "-"), 1))], 2)]))), 128)) : (a(), l("div", Ce, "-"))]), _: 1 })) : _("", true), M(n, { label: "操作", width: "160px", align: "center", fixed: "right" }, { default: u((t) => [t.row.productTypeList.length > 0 ? (a(true), l(h, { key: 0 }, f(t.row.productTypeList, (e, d) => (a(), l("div", { key: e.id }, [L("div", { class: T(d === t.row.productTypeList.length - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [e.isModify ? (a(), l(h, { key: 0 }, [N((a(), c(b, { type: "info", size: "default", onClick: (m) => k(t.row, d) }, { default: u(() => r[0] || (r[0] = [U(" 取消 ")])), _: 2, __: [0] }, 1032, ["onClick"])), [[w, I.value]]), N((a(), c(b, { type: "primary", size: "default", onClick: (m) => ee(t.row, d) }, { default: u(() => r[1] || (r[1] = [U(" 保存 ")])), _: 2, __: [1] }, 1032, ["onClick"])), [[w, I.value]])], 64)) : (a(), l(h, { key: 1 }, [i(ue)(i(K).edit) ? (a(), c(b, { key: 0, size: "default", onClick: (m) => Z(t.row, d), icon: "el-icon-edit", type: "primary", disabled: E.value }, null, 8, ["onClick", "disabled"])) : _("", true)], 64))], 2)]))), 128)) : (a(), l("div", Pe))]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[w, i(y).loading]])])) : (a(), l("div", Ee, [M(S, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: u(() => r[2] || (r[2] = [U(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [2] })]))]);
  };
} }, Ne = ne(Ie, [["__scopeId", "data-v-612c25e6"]]);
export {
  Ne as default
};
