import { ref as f } from "vue";
import { inject as ne } from "vue";
import { computed as Q } from "vue";
import { watch as le } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as w } from "vue";
import { vShow as q } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as o } from "vue";
import { unref as p } from "vue";
import { withCtx as u } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as i } from "vue";
import { createBlock as N } from "vue";
import { ElMessageBox as oe } from "element-plus";
import { ElNotification as re } from "element-plus";
import { ElTag as ue } from "element-plus";
import { ElTableColumn as ie } from "element-plus";
import { ElInputNumber as se } from "element-plus";
import { ElForm as de } from "element-plus";
import { vLoading as ce } from "element-plus";
import { l as E, _ as me, o as pe, x as ge, p$ as fe, p as ye, bV as k, P as he, ba as _e } from "../../../../../shared/runtime.js";
import ve from "./module/header.vue.js";
function be(c) {
  return E({ url: "/api/mes/building/production-wage-manage/yield-confirm/unaudited-list", method: "get", params: c });
}
function xe(c) {
  return E({ url: "/api/mes/building/production-wage-manage/yield-confirm/approve", method: "post", data: c });
}
const we = { get: be };
const Ne = { class: "head-container operation" }, ke = { key: 1 }, Se = { key: 1 }, Te = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, emits: ["success"], setup(c, { emit: W }) {
  const g = c, _ = f(), V = f(), L = f([]), v = f(false), l = f([]), S = f(false), { maxHeight: U } = pe({ paginate: true, extraBox: ".operation", extraHeight: 40 }), b = ne("query"), B = W, O = Q(() => "" + g.projectData.teamLeaderName + g.projectData.workshopName + g.projectData.processName);
  le(() => O.value, (e) => {
    e && (l.value = [], s.toQuery());
  });
  const { crud: s, form: A, CRUD: T } = ge({ title: "产量确认详情", permission: { ...fe }, crudApi: { ...we }, hasPagination: true, queryOnPresenterCreated: false }, _), H = Q(() => [["totalWage", ["to-thousand", 3]]]);
  function P(e) {
    return _e(e, { props: ["measurementQuantity", ["totalWage", 3]], toThousandFields: ["totalWage"] });
  }
  T.HOOK.beforeToQuery = () => {
    s.query.processId = g.projectData.processId, s.query.productType = g.projectData.productType, s.query.teamLeaderName = g.projectData.teamLeaderName, s.query.selectedDate = b.selectedDate, s.query.workshopId = g.projectData.workshopId, s.query.yearMonthDaySelect = b.yearMonthDaySelect;
  }, T.HOOK.afterRefresh = async (e) => {
    let a = 1;
    l.value.length && e.data.forEach((n) => {
      l.value.forEach((m) => {
        var r;
        n.produceTeamReportId === m.produceTeamReportId && ((r = _.value) == null || r.toggleRowSelection(n, true), n.selected = true, n.measurementQuantity = m.measurementQuantity, n.wage = m.wage, n.totalWage = m.totalWage);
      });
    }), e.data.forEach((n) => {
      n.index = a, a++;
    }), S.value = true;
  };
  function $(e, a) {
    s.data[a].measurementQuantity = e.measurementQuantity, e.measurementQuantity && e.wage && (e.totalWage = k(e.measurementQuantity * e.wage, 3));
  }
  function M(e, a) {
    s.data[a].wage = e.wage, e.measurementQuantity && e.wage && (e.totalWage = k(e.measurementQuantity * e.wage, 3));
  }
  const F = (e, a) => {
    if (e.length && e.indexOf(a) !== -1) a.selected = true, l.value.push(a);
    else {
      const n = l.value.indexOf(a.produceTeamReportId);
      l.value.splice(n, 1), a.selected = false;
    }
  }, K = (e) => {
    const a = s.data.filter((n) => n.disabled !== true);
    e.length === a.length ? (a.forEach((n) => {
      n.selected = true;
    }), l.value = [...l.value, ...a], l.value = [...new Set(l.value)]) : a.forEach((n) => {
      n.selected = false;
      const m = l.value.indexOf(n.produceTeamReportId);
      l.value.splice(m, 1);
    });
  };
  function z(e, a) {
    return (e.measurementUnit === "-" || e.measurementQuantity === "-" || e.wage === "-") && (e.disabled = true), e.measurementUnit !== "-" || e.measurementQuantity !== "-" || e.wage !== "-";
  }
  const G = (e) => {
    L.value = e;
  };
  async function J(e) {
    oe.confirm("是否确认通过选中的数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      v.value = true, l.value.forEach((a) => {
        console.log(a.totalWage, "totalWage"), a.totalWage = parseFloat(a.totalWage.replace(/,/g, "")), a.boltSleeveList && l.value.push(...a.boltSleeveList);
      }), await xe(l.value), re({ title: "修改成功", type: "success" }), B("success"), l.value = [], s.toQuery();
    }).catch((a) => {
      console.log(a);
    }).finally(() => {
      v.value = false;
    });
  }
  function X(e) {
    return e != null && e.boltSleeveList ? e == null ? void 0 : e.id : (e == null ? void 0 : e.id) + "only";
  }
  function Y({ row: e, rowIndex: a }) {
    return e.index ? "" : "hidden-select";
  }
  function Z({ row: e, rowIndex: a }) {
    return e.index ? "" : "hidden-select";
  }
  return (e, a) => {
    var D, C;
    const n = R("common-button"), m = ue, r = ie, j = se, ee = R("common-table"), te = de, ae = ce;
    return y(), x("div", null, [w(d("div", null, a[0] || (a[0] = [d("div", { class: "my-code" }, "*点击左侧项目行查看详情", -1)]), 512), [[q, !((D = c.projectData) != null && D.teamLeaderName)]]), w(d("div", null, [d("div", Ne, [o(ve, { data: c.projectData, "project-query": p(b) }, null, 8, ["data", "project-query"]), o(n, { class: "pass-btn", type: "success", loading: v.value, disabled: !l.value.length, onClick: J }, { default: u(() => a[1] || (a[1] = [I("通过")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), o(m, { effect: "plain", style: { "margin-bottom": "10px" } }, { default: u(() => [I("已勾选" + i(l.value.length) + "条", 1)]), _: 1 }), o(te, { ref_key: "formRef", ref: V, model: p(A), size: "default", "label-width": "80px" }, { default: u(() => [w((y(), N(ee, { ref_key: "tableRef", ref: _, style: { width: "100%", "max-width": "1227px" }, data: p(s).data, "max-height": p(U), "show-summary": "", "return-source-data": "", "data-format": H.value, "summary-method": P, "tree-props": { children: "boltSleeveList" }, "default-expand-all": S.value, "row-key": (t) => X(t), "row-class-name": Y, "cell-class-name": Z, onSelect: F, onSelectAll: K, onSelectionChange: G }, { default: u(() => [o(r, { type: "selection", width: "55", align: "center", selectable: z }), o(r, { label: "序号", prop: "index", key: "index", align: "center", width: "60" }, { default: u((t) => [d("span", null, i(t.row.index), 1)]), _: 1 }), o(r, { label: "项目名称", prop: "projectName", key: "projectName", align: "center", width: "130" }, { default: u((t) => [d("div", null, i(t.row.projectSerialNumber) + " " + i(t.row.projectName) + " - " + i(t.row.monomerName), 1)]), _: 1 }), o(r, { label: "报工时间", prop: "produceTeamReportTime", key: "produceTeamReportTime", align: "center", width: "130" }, { default: u((t) => [d("div", null, i(t.row.produceTeamReportTime ? p(ye)(t.row.produceTeamReportTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), o(r, { label: "名称", prop: "productName", key: "productName", align: "center" }, { default: u((t) => [d("div", null, i(t.row.productName || "-"), 1)]), _: 1 }), o(r, { label: "编号", prop: "productSerialNumber", key: "productSerialNumber", align: "center" }, { default: u((t) => [d("div", null, i(t.row.productSerialNumber || "-"), 1)]), _: 1 }), o(r, { label: "规格", prop: "productSpecification", key: "productSpecification", align: "center" }, { default: u((t) => [d("div", null, i(t.row.productSpecification || "-"), 1)]), _: 1 }), o(r, { label: "数量", prop: "quantity", key: "quantity", align: "center" }, { default: u((t) => [d("div", null, i(t.row.quantity), 1)]), _: 1 }), o(r, { label: "计量量", prop: "measurementQuantity", key: "measurementQuantity", align: "center", width: "140px" }, { default: u((t) => [t.row.selected ? (y(), N(j, { key: 0, modelValue: t.row.measurementQuantity, "onUpdate:modelValue": (h) => t.row.measurementQuantity = h, "controls-position": "right", step: 1, max: 999999999, min: 0, onChange: (h) => $(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (y(), x("span", ke, i(t.row.measurementQuantity || "-"), 1))]), _: 1 }), o(r, { label: "计量单位", prop: "measurementUnit", key: "measurementUnit", align: "center" }, { default: u((t) => [d("div", null, i(t.row.measurementUnit || "-"), 1)]), _: 1 }), o(r, { label: "定额单价（元）", prop: "wage", key: "wage", align: "center", width: "140px" }, { default: u((t) => [t.row.selected ? (y(), N(j, { key: 0, modelValue: t.row.wage, "onUpdate:modelValue": (h) => t.row.wage = h, "controls-position": "right", step: 1, max: 999999999e-2, min: 0, precision: 2, onChange: (h) => M(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])) : (y(), x("span", Se, i(p(k)(t.row.wage)), 1))]), _: 1 }), o(r, { label: "工价（元）", prop: "totalWage", key: "totalWage", align: "center" }, { default: u((t) => [d("div", null, i(t.row.totalWage || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format", "default-expand-all", "row-key"])), [[ae, p(s).loading]])]), _: 1 }, 8, ["model"]), o(p(he))], 512), [[q, (C = c.projectData) == null ? void 0 : C.teamLeaderName]])]);
  };
} }, Qe = me(Te, [["__scopeId", "data-v-30af0606"]]);
export {
  Qe as default
};
