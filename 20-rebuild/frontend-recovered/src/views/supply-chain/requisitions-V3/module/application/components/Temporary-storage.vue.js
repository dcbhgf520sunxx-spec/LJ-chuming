import { useStore as q } from "vuex";
import { ref as g } from "vue";
import { watch as H } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as L } from "vue";
import { createVNode as f } from "vue";
import { withCtx as s } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as r } from "vue";
import { withModifiers as U } from "vue";
import { createTextVNode as v } from "vue";
import { unref as e } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as Q } from "vue";
import { isRef as z } from "vue";
import { Fragment as G } from "vue";
import { ElMessageBox as J } from "element-plus";
import { ElMessage as x } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElTag as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { _ as Y, w0 as Z, u as $, w5 as ee, jP as te, x as ae, w9 as S, o as oe, t0 as re, G as ie, an as se, wa as le } from "../../../../../../shared/runtime.js";
import ne from "../../form.vue.js";
import "../steel/index.vue.js";
import "./common-wrapper.vue.js";
import "./common-footer.vue.js";
import "./confirm-dialog.vue.js";
import "../steel/module/steel-plate-table.vue.js";
import "../steel/module/section-steel-table.vue.js";
import "../steel/module/steel-coil-table.vue.js";
import "../steel/module/other-steel-materials-table.vue.js";
import "./inventory-drawer.vue.js";
import "./capsule-label/index.vue.js";
import "../auxiliary-material/index.vue.js";
import "../../../../../../modules/aux-material-a427f83d.js";
import "../auxiliary-material/module/aux-mat-table.vue.js";
import "../manufactured/index.vue.js";
import "../manufactured/module/enclosure-table.vue.js";
import "../manufactured/module/structure-table.vue.js";
import "../other/index.vue.js";
import "../../../../../../modules/other-e93f8d3e.js";
import "../gas/index.vue.js";
const me = { __name: "Temporary-storage", props: { modelValue: { type: Boolean, default: false }, isManufactured: { type: Boolean, default: false } }, emits: ["saveSuccess", "update:modelValue", "manuf-del", "success"], setup(j, { emit: k }) {
  const d = Z.scmTemporaryStoragePM, R = q(), b = k, C = j, V = { add: true, edit: true, del: false, download: false }, w = g(), { visible: u, handleClose: E } = $({ emit: b, props: C }), A = g([["project", ["parse-project", { onlyShortName: true }]], ["reviewStatus", ["parse-enum", ee, { f: "L" }]], ["materialType", ["parse-enum", te, { f: "L", bit: true, split: "、" }]], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: B, crud: l, columns: n } = ae({ title: "材料申购", permission: { ...d }, invisibleColumns: [], dataPath: "", requiredQuery: ["isOpened"], crudApi: { ...S, get: S.getTS }, optShow: { ...V } }, w), T = g(), { maxHeight: D } = oe({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, T);
  B.HOOK.handleRefresh = (h, { data: m }) => {
    m.forEach((t) => {
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
      await le(), l.refresh(), x({ type: "success", message: "删除成功" });
    }).catch(() => {
      x({ type: "info", message: "取消清空" });
    });
  }
  return H(u, async (h) => {
    h === true ? (l.query.isOpened = true, l.refresh()) : (await R.dispatch("approval_list/fetchTSNum", re.REQUISITIONS_V2.V), l.query.isOpened = void 0, b("success"));
  }), (h, m) => {
    const t = y("common-button"), a = K, _ = W, p = y("common-table"), O = y("common-dialog"), I = F("permission"), P = X;
    return o(), L(G, null, [f(O, { ref_key: "dialogRef", ref: T, modelValue: e(u), "onUpdate:modelValue": m[0] || (m[0] = (c) => z(u) ? u.value = c : null), "before-close": e(E), "custom-class": "requisitions-application-preview", fullscreen: "", title: "暂存列表" }, { titleRight: s(() => [N((o(), r(t, { class: "filter-item", type: "danger", onClick: U(M, ["stop"]) }, { default: s(() => m[1] || (m[1] = [v(" 一键清空 ")])), _: 1, __: [1] })), [[I, e(d).delAll]])]), default: s(() => [e(u) ? N((o(), r(p, { key: 0, ref_key: "tableRef", ref: w, data: e(l).data, "data-format": A.value, "max-height": e(D), style: { width: "100%" } }, { default: s(() => [f(a, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("createTime") ? (o(), r(a, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : i("", true), e(n).visible("departmentName") ? (o(), r(a, { key: "departmentName", align: "center", label: "部门", "min-width": "100", prop: "departmentName", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("applicantName") ? (o(), r(a, { key: "applicantName", align: "center", label: "创建人", "min-width": "150", prop: "applicantName", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("branchCompany.name") ? (o(), r(a, { key: "branchCompany.name", align: "left", label: "申购单位", "min-width": "200", prop: "branchCompany.name", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("serialNumber") ? (o(), r(a, { key: "serialNumber", align: "left", label: "申购编号", "min-width": "200", prop: "serialNumber", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("materialType") ? (o(), r(a, { key: "materialType", align: "center", label: "材料分类", "min-width": "100", prop: "materialType", "show-overflow-tooltip": "" }, { default: s(({ row: c }) => [f(_, { type: c.materialTypeTag, effect: "plain", size: "large" }, { default: s(() => [v(Q(c.materialType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : i("", true), e(ie)([...e(d).edit, ...e(d).del]) ? (o(), r(a, { key: 6, align: "center", fixed: "right", label: "操作", width: "170" }, { default: s(({ row: { sourceRow: c } }) => [f(se, { data: { id: c.id }, "del-icon": "el-icon-delete", "del-type": "danger", delPrompt: "确定删除本条数据吗？", permission: e(d) }, null, 8, ["data", "permission"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[P, e(l).loading]]) : i("", true)]), _: 1 }, 8, ["modelValue", "before-close"]), f(ne, { "is-ts-data": "" })], 64);
  };
} }, Ae = Y(me, [["__scopeId", "data-v-12834ab2"]]);
export {
  Ae as default
};
