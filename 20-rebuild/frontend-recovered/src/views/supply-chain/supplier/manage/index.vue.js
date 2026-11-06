import { useStore as P } from "vuex";
import { ref as C } from "vue";
import { onMounted as U } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as $ } from "vue";
import { createVNode as o } from "vue";
import { unref as i } from "vue";
import { withDirectives as K } from "vue";
import { createBlock as c } from "vue";
import { withCtx as b } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as q } from "vue";
import { createTextVNode as F } from "vue";
import { ElMessageBox as G } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { InfoFilled as j } from "@element-plus/icons-vue";
import { ElIcon as z } from "element-plus";
import { ElTooltip as W } from "element-plus";
import { ElSwitch as Z } from "element-plus";
import { vLoading as J } from "element-plus";
import { x as Q, wZ as O, w_ as X, o as ee, p as te, w$ as ne, iW as ie, G as ae, ln as h, an as oe, P as re, x0 as le } from "../../../../shared/runtime.js";
import { g as se, a as ce } from "../../../../modules/supplier-evaluation-config-2fb6916b.js";
import ue from "./module/header.vue.js";
import me from "./module/form.vue.js";
import pe from "./module/detail.vue.js";
import fe from "./module/batch-form.vue.js";
import "../../../plan/technical-manage/artifact-tree/module/ExcelUploadBtnV2.vue.js";
import "../../../../modules/region-cascader-39b54da2.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const de = { class: "app-container" }, Ae = { __name: "index", setup(ge) {
  const L = P(), w = { batchAdd: true, add: true, edit: false, del: true, download: false }, A = C(), { crud: d, columns: u, CRUD: g } = Q({ title: "供应商", sort: ["id.desc"], formStore: true, formStoreKey: "SUPPLY_CHAIN_SUPPLIER_MANAGE", invisibleColumns: ["createTime", "updateTime", "scmSupplierConfigDTOName"], permission: { ...O }, optShow: { ...w }, crudApi: { ...X } }, A), { maxHeight: I } = ee({ paginate: true }), v = C({}), S = C({}), V = C([]);
  U(() => {
    B();
  });
  async function k(e, n) {
    try {
      await G.confirm(`此操作将"${h.VL[n]}"${e.name}
${n === h.TRUE.V ? `被隐藏后，无法在订单编辑中搜索到该供应商
` : ""} 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await le({ id: e.id, boolHide: n }), d.refresh(), d.notify(h.VL[n] + "成功", g.NOTIFICATION_TYPE.SUCCESS);
    } catch (t) {
      console.log("操作供应商状态", t), e.enabled = !e.enabled;
    }
  }
  g.HOOK.handleRefresh = (e, n) => {
    n.data.content = n.data.content.map((t) => (t.createTime = te(t.createTime), t.supplierClassification = ne(ie, parseInt(t.supplierClassification), "、"), t.scoreRating = H(t), t.scmSupplierConfigDTOName = D(t), t));
  };
  function T() {
    L.dispatch("config/fetchSuppliers");
  }
  g.HOOK.afterSubmit = () => {
    T();
  }, g.HOOK.afterBatchAddSuccess = () => {
    T();
  }, g.HOOK.afterDelete = () => {
    T();
  }, g.HOOK.beforeToAdd = (e, n) => {
    e.form.processType = e.query.processType, e.form.sequenceType = e.query.sequenceType;
  };
  async function B() {
    try {
      const [e, n] = await Promise.allSettled([se(), ce()]);
      if (e.status === "fulfilled") {
        const t = R(e.value);
        v.value = t.reduce((a, r) => (a[r.id] = r.name, a), {});
      }
      if (n.status === "fulfilled") {
        const t = R(n.value).map((a) => ({ id: a.id, name: a.name || "", minValue: Number(a.minValue), maxValue: Number(a.maxValue) }));
        V.value = t, S.value = t.reduce((a, r) => (a[r.id] = r.name, a), {});
      }
    } catch (e) {
      console.log("供应商管理-评价配置读取失败", e);
    }
  }
  function D(e = {}) {
    var a, r, m, l, p;
    const n = [(a = e.scmSupplierConfigDTO) == null ? void 0 : a.name, e.evaluationCategoryLabel, e.evaluationCategoryName, e.classifyName, (r = e.evaluationCategory) == null ? void 0 : r.name, (m = e.classify) == null ? void 0 : m.name].find((x) => _(x));
    if (n) return n;
    const t = N(e.evaluationCategoryId, e.classifyId, (l = e.evaluationCategory) == null ? void 0 : l.id, (p = e.classify) == null ? void 0 : p.id);
    return _(t) && v.value[t] !== void 0 ? v.value[t] : "-";
  }
  function H(e = {}) {
    var r, m;
    const n = [e.scoreRating, e.ratingLabel, e.scoreRatingName, e.ratingName, e.rating, (r = e.scoreRating) == null ? void 0 : r.name].find((l) => _(l));
    if (n) return n;
    const t = N(e.scoreRatingId, e.ratingId, (m = e.scoreRating) == null ? void 0 : m.id);
    if (_(t) && S.value[t]) return S.value[t];
    const a = Number(N(e.score, e.totalScore, e.evaluationScore));
    if (!Number.isNaN(a)) {
      const l = V.value.find((p) => a >= Number(p.minValue) && a <= Number(p.maxValue));
      if (l != null && l.name) return l.name;
    }
    return "-";
  }
  function N(...e) {
    return e.find((n) => n != null && n !== "");
  }
  function _(e) {
    return e != null && e !== "";
  }
  function R(e) {
    var n;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((n = e == null ? void 0 : e.data) == null ? void 0 : n.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  return (e, n) => {
    const t = Y, a = j, r = z, m = W, l = Z, p = M("common-table"), x = J;
    return s(), $("div", de, [o(i(ue)), K((s(), c(p, { ref_key: "tableRef", ref: A, data: i(d).data, "return-source-data": "", "show-empty-symbol": false, "empty-text": i(d).emptyText, "max-height": i(I), onSelectionChange: i(d).selectionChangeHandler, "row-key": "id" }, { default: b(() => [o(t, { type: "selection", width: "55", align: "center" }), o(t, { label: "序号", type: "index", align: "center", width: "60" }), i(u).visible("name") ? (s(), c(t, { key: "name", "show-overflow-tooltip": true, prop: "name", "min-width": "150", label: "供应商名称" })) : f("", true), i(u).visible("shortName") ? (s(), c(t, { key: "shortName", "show-overflow-tooltip": true, prop: "shortName", "min-width": "120", label: "供应商简称" })) : f("", true), i(u).visible("area") ? (s(), c(t, { key: "area", "show-overflow-tooltip": true, prop: "area", label: "地区", "min-width": "150" })) : f("", true), i(u).visible("supplierClassification") ? (s(), c(t, { key: "supplierClassification", "max-width": "320", "show-overflow-tooltip": true, prop: "supplierClassification", label: "供应商分类" })) : f("", true), i(u).visible("ratingLabel") ? (s(), c(t, { key: "ratingLabel", "show-overflow-tooltip": true, prop: "scoreRating", "min-width": "110", align: "center", label: "评级" })) : f("", true), i(u).visible("scmSupplierConfigDTOName") ? (s(), c(t, { key: "scmSupplierConfigDTOName", "show-overflow-tooltip": true, prop: "scmSupplierConfigDTOName", "min-width": "110", align: "center", label: "评价分类" })) : f("", true), o(t, { align: "center" }, { header: b(() => [o(m, { class: "item", effect: "light", content: "被隐藏后，无法在订单编辑中搜索到该供应商", placement: "top" }, { default: b(() => [q("span", null, [n[0] || (n[0] = F("列入隐藏列表 ")), o(r, null, { default: b(() => [o(a)]), _: 1 })])]), _: 1 })]), default: b(({ row: y }) => [o(l, { modelValue: y.enabled, "onUpdate:modelValue": (E) => y.enabled = E, disabled: !i(ae)(i(O).editStatus), "active-color": "#ff4949", "inactive-color": "#909399", "active-value": i(h).TRUE.V, "inactive-value": i(h).FALSE.V, onChange: (E) => k(y, y.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 }), i(u).visible("createTime") ? (s(), c(t, { key: "createTime", prop: "createTime", label: "创建时间", width: "140px" })) : f("", true), o(t, { label: "操作", width: "180px", align: "center", fixed: "right" }, { default: b(({ row: y }) => [o(i(oe), { "show-detail": "", data: { id: y.id } }, null, 8, ["data"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSelectionChange"])), [[x, i(d).loading]]), o(i(re)), o(i(me)), o(i(pe)), o(i(fe))]);
  };
} };
export {
  Ae as default
};
