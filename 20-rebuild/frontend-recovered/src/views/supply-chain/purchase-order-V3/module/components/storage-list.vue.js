import { useStore as F } from "vuex";
import { ref as A } from "vue";
import { watch as H } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as I } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as m } from "vue";
import { withCtx as n } from "vue";
import { withModifiers as K } from "vue";
import { createTextVNode as C } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createBlock as o } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as g } from "vue";
import { createElementVNode as z } from "vue";
import { isRef as J } from "vue";
import { Fragment as Q } from "vue";
import { ElMessageBox as W } from "element-plus";
import { ElMessage as V } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElTag as Y } from "element-plus";
import { vLoading as G } from "element-plus";
import { _ as Z, uM as $, u as ee, jP as te, cP as ae, jS as oe, fE as se, x as le, uN as re, uW as ie, o as ne, i as pe, gD as x, an as ce, uJ as ue, uX as me } from "../../../../../shared/runtime.js";
const de = { key: 1 }, be = { key: 0 }, fe = { __name: "storage-list", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success"], setup(S, { emit: E }) {
  const d = $.scmTemporaryStoragePM, w = F(), v = E, B = S, O = { add: true, edit: true, del: false, download: false }, j = A(), { visible: u, handleClose: R } = ee({ emit: v, props: B }), D = A([["materialType", ["parse-enum", te, { f: "L", bit: true, split: "、" }]], ["basicClass", ["parse-enum", ae, { f: "L", bit: true, split: "、" }]], ["boolAnnual", ["parse-enum", oe]], ["level", ["parse-enum", se, { f: "SL" }]], ["amount", ["to-thousand-ck", "YUAN"]], ["createTime", "parse-time"]]), { CRUD: N, crud: p, columns: r } = le({ title: "采购订单暂存列表", permission: { ...d }, invisibleColumns: [], dataPath: "", requiredQuery: ["isOpened"], crudApi: { ...re, get: ie }, optShow: { ...O } }, j), { maxHeight: L } = ne({ paginate: true });
  N.HOOK.handleRefresh = (h, { data: c }) => {
    c.map((s) => {
      var a, b;
      s.boolAnnual = !!s.boolAnnual, s.projects = (a = s.project) != null && a.id ? [s.project] : s.projects, s.projectNames = [], (b = s.projects) == null || b.forEach((f) => {
        s.projectNames.push(f.serialNumber + " " + f.name);
      }), s.projectNames = s.projectNames.join("、");
    });
  }, N.HOOK.afterDelete = async () => {
    await w.dispatch("config/fetchSupplyUsedProject");
  };
  function M() {
    W.confirm("是否删除所有的数据", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "提示" }).then(async () => {
      await me(), p.refresh(), V({ type: "success", message: "删除成功" }), await w.dispatch("config/fetchSupplyUsedProject");
    }).catch(() => {
      V({ type: "info", message: "取消清空" });
    });
  }
  return H(u, async (h) => {
    h === true ? (p.query.isOpened = true, p.refresh()) : (p.query.isOpened = void 0, v("success"));
  }), (h, c) => {
    const s = _("common-button"), a = X, b = Y, f = _("common-table"), P = _("common-dialog"), U = I("permission"), q = G;
    return t(), y(Q, null, [m(P, { modelValue: e(u), "onUpdate:modelValue": c[0] || (c[0] = (i) => J(u) ? u.value = i : null), "before-close": e(R), "custom-class": "storage-preview", fullscreen: "", title: "暂存列表" }, { titleRight: n(() => [m(s, { size: "default", type: "danger", onClick: K(M, ["stop"]) }, { default: n(() => c[1] || (c[1] = [C("一键清空")])), _: 1, __: [1] })]), default: n(() => [e(u) ? T((t(), o(f, { key: 0, ref_key: "tableRef", ref: j, data: e(p).data, "data-format": D.value, "max-height": e(L), style: { width: "100%" } }, { default: n(() => [m(a, { align: "center", label: "序号", type: "index", width: "60" }), e(r).visible("createTime") ? (t(), o(a, { key: "createTime", align: "center", label: "创建日期", prop: "createTime", width: "150" })) : l("", true), e(r).visible("projectAttribute") ? (t(), o(a, { key: "projectAttribute", align: "center", label: "经营方式", "min-width": "90", prop: "projectAttribute", "show-overflow-tooltip": "" }, { default: n(({ row: { sourceRow: i } }) => {
      var k;
      return [e(pe)(i.projectAttribute) ? (t(), o(b, { key: 0, type: (k = e(x).V[i.projectAttribute]) == null ? void 0 : k.T }, { default: n(() => [C(g(e(x).VL[i.projectAttribute]), 1)]), _: 2 }, 1032, ["type"])) : (t(), y("span", de, "-"))];
    }), _: 1 })) : l("", true), e(r).visible("boolAnnual") ? (t(), o(a, { key: "boolAnnual", align: "center", label: "合同类型", prop: "boolAnnual", width: "90" })) : l("", true), e(r).visible("serialNumber") ? (t(), o(a, { key: "serialNumber", align: "center", label: "采购合同号", "min-width": "90", prop: "serialNumber" })) : l("", true), e(r).visible("serialNumber") ? (t(), o(a, { key: "serialNumber", align: "center", label: "材料类型", "min-width": "170", prop: "serialNumber", "show-overflow-tooltip": "" }, { default: n(({ row: i }) => [i.materialType ? (t(), y("span", be, g(i.materialType + "-"), 1)) : l("", true), z("span", null, g(i.basicClass), 1)]), _: 1 })) : l("", true), e(r).visible("projectNames") ? (t(), o(a, { key: "projectNames", label: "所属项目", "min-width": "170", prop: "projectNames", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("supplier.name") ? (t(), o(a, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", prop: "supplier.name" })) : l("", true), e(r).visible("branchCompany.name") ? (t(), o(a, { key: "branchCompany.name", label: "签订主体", "min-width": "170", prop: "branchCompany.name", "show-overflow-tooltip": "" })) : l("", true), e(r).visible("level") ? (t(), o(a, { key: "level", align: "center", label: "目的地", prop: "level", "show-overflow-tooltip": "", width: "90" })) : l("", true), e(r).visible("amount") ? (t(), o(a, { key: "amount", align: "amount", label: "合同额", prop: "amount", "show-overflow-tooltip": "", width: "90" })) : l("", true), e(r).visible("applicantName") ? (t(), o(a, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", "show-overflow-tooltip": "", width: "90" })) : l("", true), T((t(), o(a, { align: "center", label: "操作", width: "170" }, { default: n(({ row: { sourceRow: i } }) => [m(ce, { data: i }, null, 8, ["data"])]), _: 1 })), [[U, [...e(d).detail, ...e(d).edit, ...e(d).del]]])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[q, e(p).loading]]) : l("", true)]), _: 1 }, 8, ["modelValue", "before-close"]), m(ue)], 64);
  };
} }, ye = Z(fe, [["__scopeId", "data-v-92769b41"]]);
export {
  ye as default
};
