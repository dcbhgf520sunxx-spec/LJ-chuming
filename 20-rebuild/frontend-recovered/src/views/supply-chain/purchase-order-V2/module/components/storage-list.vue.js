import { useStore as M } from "vuex";
import { ref as N } from "vue";
import { watch as L } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as m } from "vue";
import { withCtx as c } from "vue";
import { withModifiers as H } from "vue";
import { createTextVNode as q } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as s } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as j } from "vue";
import { createElementVNode as F } from "vue";
import { isRef as W } from "vue";
import { Fragment as I } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElMessage as T } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as J } from "element-plus";
import { _ as Q, u as X, jP as Y, cP as G, jS as Z, fE as $, x as ee, uN as ae, uW as te, o as oe, t0 as se, an as le, uJ as re, uM as ie, uX as ne } from "../../../../../shared/runtime.js";
const pe = { key: 0 }, ce = { __name: "storage-list", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success"], setup(V, { emit: S }) {
  const d = ie.scmTemporaryStoragePM, h = M(), g = S, x = V, P = { add: true, edit: true, del: false, download: false }, w = N(), { visible: u, handleClose: A } = X({ emit: g, props: x }), E = N([["materialType", ["parse-enum", Y, { f: "L", bit: true, split: "、" }]], ["basicClass", ["parse-enum", G, { f: "L", bit: true, split: "、" }]], ["boolAnnual", ["parse-enum", Z]], ["orderPlace", ["parse-enum", $, { f: "SL" }]], ["amount", ["to-thousand-ck", "YUAN"]], ["createTime", "parse-time"]]), { CRUD: v, crud: n, columns: r } = ee({ title: "采购订单暂存列表", permission: { ...d }, invisibleColumns: [], dataPath: "", requiredQuery: ["isOpened"], crudApi: { ...ae, get: te }, optShow: { ...P } }, w), { maxHeight: R } = oe({ paginate: true });
  v.HOOK.handleRefresh = (_, { data: p }) => {
    p.map((o) => {
      var a, f;
      o.boolAnnual = !!o.boolAnnual, o.projects = (a = o.project) != null && a.id ? [o.project] : o.projects, o.projectNames = [], (f = o.projects) == null || f.forEach((b) => {
        o.projectNames.push(b.serialNumber + " " + b.name);
      }), o.projectNames = o.projectNames.join("、");
    });
  }, v.HOOK.afterDelete = async () => {
    await h.dispatch("config/fetchSupplyUsedProject");
  };
  function O() {
    K.confirm("是否删除所有的数据", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "提示" }).then(async () => {
      await ne(), n.refresh(), T({ type: "success", message: "删除成功" }), await h.dispatch("config/fetchSupplyUsedProject");
    }).catch(() => {
      T({ type: "info", message: "取消清空" });
    });
  }
  return L(u, async (_) => {
    _ === true ? (n.query.isOpened = true, n.refresh()) : (n.query.isOpened = void 0, await h.dispatch("approval_list/fetchTSNum", se.PURCHASE_ORDER_V2.V), g("success"));
  }), (_, p) => {
    const o = y("common-button"), a = z, f = y("common-table"), b = y("common-dialog"), B = U("permission"), D = J;
    return t(), k(I, null, [m(b, { modelValue: e(u), "onUpdate:modelValue": p[0] || (p[0] = (i) => W(u) ? u.value = i : null), "before-close": e(A), "custom-class": "storage-preview", fullscreen: "", title: "暂存列表" }, { titleRight: c(() => [m(o, { size: "default", type: "danger", onClick: H(O, ["stop"]) }, { default: c(() => p[1] || (p[1] = [q("一键清空")])), _: 1, __: [1] })]), default: c(() => [e(u) ? C((t(), s(f, { key: 0, ref_key: "tableRef", ref: w, data: e(n).data, "data-format": E.value, "max-height": e(R), style: { width: "100%" } }, { default: c(() => [m(a, { align: "center", label: "序号", type: "index", width: "60" }), e(r).visible("createTime") ? (t(), s(a, { key: "createTime", align: "center", label: "创建日期", prop: "createTime", width: "150" })) : l("", true), e(r).visible("boolAnnual") ? (t(), s(a, { key: "boolAnnual", align: "center", label: "合同类型", prop: "boolAnnual", width: "90" })) : l("", true), e(r).visible("serialNumber") ? (t(), s(a, { key: "serialNumber", align: "center", label: "采购合同号", "min-width": "120", prop: "serialNumber" })) : l("", true), e(r).visible("serialNumber") ? (t(), s(a, { key: "serialNumber", align: "center", label: "材料类型", "min-width": "170", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: c(({ row: i }) => [i.materialType ? (t(), k("span", pe, j(i.materialType + "-"), 1)) : l("", true), F("span", null, j(i.basicClass), 1)]), _: 1 })) : l("", true), e(r).visible("mesWorkshop.name") ? (t(), s(a, { key: "mesWorkshop.name", "show-overflow-tooltip": true, label: "关联车间", "min-width": "150", prop: "mesWorkshop.name" })) : l("", true), e(r).visible("projectNames") ? (t(), s(a, { key: "projectNames", label: "所属项目", "min-width": "170", prop: "projectNames", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("supplier.name") ? (t(), s(a, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", prop: "supplier.name" })) : l("", true), e(r).visible("branchCompany.name") ? (t(), s(a, { key: "branchCompany.name", label: "采购单位", "min-width": "170", prop: "branchCompany.name", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("orderPlace") ? (t(), s(a, { key: "orderPlace", align: "center", label: "目的地", prop: "orderPlace", "show-overflow-tooltip": "", width: "90" })) : l("", true), e(r).visible("amount") ? (t(), s(a, { key: "amount", align: "amount", label: "合同额", prop: "amount", "show-overflow-tooltip": "", width: "90" })) : l("", true), e(r).visible("applicantName") ? (t(), s(a, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", "show-overflow-tooltip": "", width: "90" })) : l("", true), C((t(), s(a, { align: "center", label: "操作", width: "170" }, { default: c(({ row: { sourceRow: i } }) => [m(le, { data: i }, null, 8, ["data"])]), _: 1 })), [[B, [...e(d).detail, ...e(d).edit, ...e(d).del]]])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[D, e(n).loading]]) : l("", true)]), _: 1 }, 8, ["modelValue", "before-close"]), m(re, { "is-passed-edit": "" })], 64);
  };
} }, de = Q(ce, [["__scopeId", "data-v-ac548cc8"]]);
export {
  de as default
};
