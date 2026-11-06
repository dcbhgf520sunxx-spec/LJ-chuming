import { useStore as q } from "vuex";
import { ref as g } from "vue";
import { watch as H } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as f } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as s } from "vue";
import { withModifiers as U } from "vue";
import { createTextVNode as v } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as Q } from "vue";
import { isRef as z } from "vue";
import { Fragment as G } from "vue";
import { ElMessageBox as J } from "element-plus";
import { ElMessage as x } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElTag as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Y, w0 as Z, u as $, w5 as ee, jP as te, x as ae, w9 as S, o as oe, t0 as se, G as re, an as ie, w2 as le, wa as ne } from "../../../../../../shared/runtime.js";
const ce = { __name: "temporary-storage", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success"], setup(j, { emit: k }) {
  const d = Z.scmTemporaryStoragePM, R = q(), b = k, C = j, V = { add: true, edit: true, del: false, download: false }, w = g(), { visible: u, handleClose: E } = $({ emit: b, props: C }), A = g([["project", ["parse-project", { onlyShortName: true }]], ["reviewStatus", ["parse-enum", ee, { f: "L" }]], ["materialType", ["parse-enum", te, { f: "L", bit: true, split: "、" }]], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: B, crud: l, columns: n } = ae({ title: "材料申购", permission: { ...d }, invisibleColumns: [], dataPath: "", requiredQuery: ["isOpened"], crudApi: { ...S, get: S.getTS }, optShow: { ...V } }, w), T = g(), { maxHeight: D } = oe({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, T);
  B.HOOK.handleRefresh = (h, { data: c }) => {
    c.forEach((t) => {
      var a, _;
      t.tsData && (t.detailList = JSON.parse(t.tsData)), t.projectNames = [], (a = t.projectInfos) == null || a.forEach((p) => {
        t.projectNames.push(p.serialNumber + " " + p.name);
      }), t.projectNames = t.projectNames.join(","), t.projectAttribute = [], (_ = t.projectInfos) == null || _.forEach((p) => {
        t.projectAttribute.push(p.projectAttribute);
      }), t.projectAttribute = Array.from(new Set(t.projectAttribute));
    });
  };
  function M() {
    J.confirm("是否删除所有的数据", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "提示" }).then(async () => {
      await ne(), l.refresh(), x({ type: "success", message: "删除成功" });
    }).catch(() => {
      x({ type: "info", message: "取消清空" });
    });
  }
  return H(u, async (h) => {
    h === true ? (l.query.isOpened = true, l.refresh()) : (await R.dispatch("approval_list/fetchTSNum", se.REQUISITIONS_V2.V), l.query.isOpened = void 0, b("success"));
  }), (h, c) => {
    const t = y("common-button"), a = K, _ = W, p = y("common-table"), O = y("common-dialog"), I = F("permission"), P = X;
    return o(), L(G, null, [f(O, { ref_key: "dialogRef", ref: T, modelValue: e(u), "onUpdate:modelValue": c[0] || (c[0] = (m) => z(u) ? u.value = m : null), "before-close": e(E), "custom-class": "requisitions-application-preview", fullscreen: "", title: "暂存列表" }, { titleRight: i(() => [N((o(), s(t, { class: "filter-item", type: "danger", onClick: U(M, ["stop"]) }, { default: i(() => c[1] || (c[1] = [v(" 一键清空 ")])), _: 1, __: [1] })), [[I, e(d).delAll]])]), default: i(() => [e(u) ? N((o(), s(p, { key: 0, ref_key: "tableRef", ref: w, data: e(l).data, "data-format": A.value, "max-height": e(D), style: { width: "100%" } }, { default: i(() => [f(a, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("createTime") ? (o(), s(a, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : r("", true), e(n).visible("departmentName") ? (o(), s(a, { key: "departmentName", align: "center", label: "部门", "min-width": "100", prop: "departmentName", "show-overflow-tooltip": "" })) : r("", true), e(n).visible("applicantName") ? (o(), s(a, { key: "applicantName", align: "center", label: "创建人", "min-width": "150", prop: "applicantName", "show-overflow-tooltip": "" })) : r("", true), e(n).visible("branchCompany.name") ? (o(), s(a, { key: "branchCompany.name", align: "left", label: "申购单位", "min-width": "200", prop: "branchCompany.name", "show-overflow-tooltip": "" })) : r("", true), e(n).visible("serialNumber") ? (o(), s(a, { key: "serialNumber", align: "left", label: "申购编号", "min-width": "200", prop: "serialNumber", "show-overflow-tooltip": "" })) : r("", true), e(n).visible("materialType") ? (o(), s(a, { key: "materialType", align: "center", label: "材料分类", "min-width": "100", prop: "materialType", "show-overflow-tooltip": "" }, { default: i(({ row: m }) => [f(_, { type: m.materialTypeTag, effect: "plain", size: "large" }, { default: i(() => [v(Q(m.materialType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : r("", true), e(re)([...e(d).edit, ...e(d).del]) ? (o(), s(a, { key: 6, align: "center", fixed: "right", label: "操作", width: "170" }, { default: i(({ row: { sourceRow: m } }) => [f(ie, { data: { id: m.id }, "del-icon": "el-icon-delete", "del-type": "danger", delPrompt: "确定删除本条数据吗？", permission: e(d) }, null, 8, ["data", "permission"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[P, e(l).loading]]) : r("", true)]), _: 1 }, 8, ["modelValue", "before-close"]), f(le, { "is-ts-data": "" })], 64);
  };
} }, de = Y(ce, [["__scopeId", "data-v-15b51a9c"]]);
export {
  de as default
};
