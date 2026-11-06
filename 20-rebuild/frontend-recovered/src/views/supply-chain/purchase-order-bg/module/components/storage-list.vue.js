import { useStore as q } from "vuex";
import { ref as F } from "vue";
import { computed as K } from "vue";
import { watch as G } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as b } from "vue";
import { withCtx as r } from "vue";
import { withModifiers as Y } from "vue";
import { createTextVNode as V } from "vue";
import { unref as e } from "vue";
import { withDirectives as S } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as c } from "vue";
import { createElementVNode as j } from "vue";
import { isRef as z } from "vue";
import { Fragment as Q } from "vue";
import { ElMessageBox as J } from "element-plus";
import { ElMessage as A } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElTag as X } from "element-plus";
import { vLoading as Z } from "element-plus";
import { _ as $, vf as ee, u as te, x as ae, vB as se, vG as oe, o as ie, da as re, bD as le, D as ne, jP as pe, cP as ce, t0 as ue, i as me, gD as D, an as de, uK as fe, vH as be } from "../../../../../shared/runtime.js";
const he = { key: 1 }, _e = { key: 0 }, ge = { key: 1 }, ye = { key: 2 }, we = { __name: "storage-list", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success"], setup(M, { emit: R }) {
  const w = ee.scmTemporaryStoragePM, v = q(), C = R, B = M, E = { add: true, edit: true, del: false, download: false }, x = F(), { visible: d, handleClose: O } = te({ emit: C, props: B }), { CRUD: T, crud: u, columns: n } = ae({ title: "采购订单暂存列表", permission: { ...w }, invisibleColumns: [], dataPath: "", requiredQuery: ["isOpened"], crudApi: { ...se, get: oe }, optShow: { ...E } }, x), { maxHeight: P } = ie({ paginate: true }), U = K(() => [...re, ["invoiceType", ["parse-enum", le]], ["amount", ["to-thousand", ne.YUAN]], ["requisitionsSNStr", "empty-text"], ["remark", "empty-text"], ["auxMaterialNames", "split"], ["otherMaterialNames", "split"], ["materialType", ["parse-enum", pe, { f: "L", bit: true, split: "、" }]], ["basicClass", ["parse-enum", ce, { f: "L", bit: true, split: "、" }]], ["amount", ["to-thousand-ck", "YUAN"]], ["createTime", "parse-time"]]);
  T.HOOK.handleRefresh = (N, { data: m }) => {
    m.map((p) => {
      var s, h, _, g, y;
      (s = p.projects) != null && s.length && (p.projectName = (h = p.projects[0]) != null && h.serialNumber ? ((_ = p.projects[0]) == null ? void 0 : _.serialNumber) + "-" + ((g = p.projects[0]) == null ? void 0 : g.name) : (y = p.projects[0]) == null ? void 0 : y.name);
    }), C("saveSuccess");
  }, T.HOOK.afterDelete = async () => {
    await v.dispatch("config/fetchSupplyUsedProject");
  };
  function L() {
    J.confirm("是否删除所有的数据", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "提示" }).then(async () => {
      await be(), u.refresh(), await v.dispatch("config/fetchSupplyUsedProject"), A({ type: "success", message: "删除成功" });
    }).catch(() => {
      A({ type: "info", message: "取消清空" });
    });
  }
  return G(d, async (N) => {
    N === true ? (u.query.isOpened = true, u.refresh()) : (u.query.isOpened = void 0, await v.dispatch("approval_list/fetchTSNum", ue.PURCHASE_ORDER_BG.V));
  }), (N, m) => {
    const p = k("common-button"), s = W, h = X, _ = k("common-table"), g = k("common-dialog"), y = I("permission"), H = Z;
    return a(), f(Q, null, [b(g, { modelValue: e(d), "onUpdate:modelValue": m[0] || (m[0] = (t) => z(d) ? d.value = t : null), "before-close": e(O), "custom-class": "storage-preview", fullscreen: "", title: "暂存列表" }, { titleRight: r(() => [b(p, { size: "default", type: "danger", onClick: Y(L, ["stop"]) }, { default: r(() => m[1] || (m[1] = [V("一键清空")])), _: 1, __: [1] })]), default: r(() => [e(d) ? S((a(), o(_, { key: 0, ref_key: "tableRef", ref: x, data: e(u).data, "data-format": U.value, "max-height": e(P), style: { width: "100%" } }, { default: r(() => [b(s, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("createTime") ? (a(), o(s, { key: "createTime", align: "center", label: "创建日期", prop: "createTime", width: "150" })) : l("", true), e(n).visible("projectAttribute") ? (a(), o(s, { key: "projectAttribute", align: "center", label: "经营方式", "min-width": "90", prop: "projectAttribute", "show-overflow-tooltip": "" }, { default: r(({ row: { sourceRow: t } }) => {
      var i;
      return [e(me)(t.projectAttribute) ? (a(), o(h, { key: 0, type: (i = e(D).V[t.projectAttribute]) == null ? void 0 : i.T }, { default: r(() => [V(c(e(D).VL[t.projectAttribute]), 1)]), _: 2 }, 1032, ["type"])) : (a(), f("span", he, "-"))];
    }), _: 1 })) : l("", true), e(n).visible("projectManager.name") ? (a(), o(s, { key: "projectManager.name", "show-overflow-tooltip": true, label: "项目经理", "min-width": "80px", prop: "projectManager.name" }, { default: r(({ row: t }) => {
      var i;
      return [j("span", null, c(((i = t.projectManager) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 })) : l("", true), e(n).visible("projectName") ? (a(), o(s, { key: "projectName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "160px", prop: "projectName" })) : l("", true), e(n).visible("serialNumber") ? (a(), o(s, { key: "serialNumber", align: "center", label: "采购合同号", "min-width": "90", prop: "serialNumber" })) : l("", true), e(n).visible("basicClass") ? (a(), o(s, { key: "basicClass", align: "center", label: "材料类型", "min-width": "170", prop: "basicClass", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => [t.materialType ? (a(), f("span", _e, c(t.materialType), 1)) : t.basicClass ? (a(), f("span", ge, c(t.basicClass), 1)) : (a(), f("span", ye, c("-")))]), _: 1 })) : l("", true), e(n).visible("supplier.shortName") ? (a(), o(s, { key: "supplier.shortName", "show-overflow-tooltip": true, label: "供应商", prop: "supplier.shortName" }, { default: r(({ row: t }) => {
      var i;
      return [j("span", null, c(((i = t.supplier) == null ? void 0 : i.shortName) || "-"), 1)];
    }), _: 1 })) : l("", true), e(n).visible("branchCompany.name") ? (a(), o(s, { key: "branchCompany.name", label: "签约主体", "min-width": "170", prop: "branchCompany.name", "show-overflow-tooltip": "" }, { default: r(({ row: t }) => {
      var i;
      return [j("span", null, c(((i = t.branchCompany) == null ? void 0 : i.name) || "-"), 1)];
    }), _: 1 })) : l("", true), e(n).visible("amount") ? (a(), o(s, { key: "amount", align: "amount", label: "合同额", prop: "amount", "show-overflow-tooltip": "", width: "90" })) : l("", true), e(n).visible("applicantName") ? (a(), o(s, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", "show-overflow-tooltip": "", width: "90" })) : l("", true), S((a(), o(s, { align: "center", label: "操作", width: "170" }, { default: r(({ row: { sourceRow: t } }) => [b(de, { data: t }, null, 8, ["data"])]), _: 1 })), [[y, [...e(w).edit, ...e(w).del]]])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[H, e(u).loading]]) : l("", true)]), _: 1 }, 8, ["modelValue", "before-close"]), b(fe, { rewriting: true })], 64);
  };
} }, ke = $(we, [["__scopeId", "data-v-99fcf0a5"]]);
export {
  ke as default
};
