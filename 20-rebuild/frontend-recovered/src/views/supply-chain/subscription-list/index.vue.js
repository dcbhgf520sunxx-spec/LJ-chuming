import { useStore as le } from "vuex";
import { ref as y } from "vue";
import { computed as H } from "vue";
import { provide as ne } from "vue";
import { watch as K } from "vue";
import { onMounted as re } from "vue";
import { resolveComponent as ce } from "vue";
import { resolveDirective as ue } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as R } from "vue";
import { createVNode as E } from "vue";
import { unref as s } from "vue";
import { withDirectives as J } from "vue";
import { createBlock as r } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as m } from "vue";
import { Fragment as pe } from "vue";
import { renderList as de } from "vue";
import { createTextVNode as A } from "vue";
import { toDisplayString as f } from "vue";
import { resolveDynamicComponent as he } from "vue";
import { ElLoading as me } from "element-plus";
import { ElMessage as fe } from "element-plus";
import { ElTableColumn as ye } from "element-plus";
import { ElTag as ge } from "element-plus";
import { vLoading as be } from "element-plus";
import { l as Q, _ as we, sQ as _e, uP as Ee, jP as N, x as Te, wJ as O, o as Se, gD as L, uJ as Ae, uK as Le, bv as ve, cP as g, z as Me, wK as x, vd as I, an as Ne, P as Ce, wL as je, i as Ve, ai as Y, cO as Pe, jR as Re, jl as Ie, wM as Ue, wN as ke, iX as $, wO as Oe, wP as xe } from "../../../shared/runtime.js";
import Fe from "./module/header.vue.js";
import De from "./module/detail.vue.js";
import qe from "../purchase-order-V2/module/oa-approval/index.vue.js";
function We(C) {
  return Q({ module: "scm_V2", url: "apply-purchase/getListAndDetail", method: "get", params: C });
}
function Be(C) {
  return Q({ module: "scm_V2", url: `apply-purchase/${C}`, method: "get" });
}
const He = { detail: Be, get: We };
const Ke = { class: "app-container" }, Je = { key: 0 }, Ye = { key: 1 }, $e = { __name: "index", setup(C) {
  const j = le(), z = { add: false, edit: false, del: false, download: false }, V = y(), { baseUnit: F } = _e(), v = y([]);
  j.dispatch("config/fetchUnit");
  const G = y([["project", ["parse-project", { onlyShortName: true }]], ["dataStatus", ["parse-enum", Ee, { f: "L" }]], ["materialTypeStr", ["parse-enum", N, { f: "L", bit: true }], { source: "materialType" }], ["createTime", "parse-time"], ["updateTime", "parse-time"]]), { CRUD: D, crud: b, columns: d } = Te({ title: "申购清单", permission: { ...O }, invisibleColumns: [], crudApi: { ...He }, optShow: { ...z } }, V), { maxHeight: X } = Se({ paginate: true }), q = H(() => b.query.boolInitiateApprove), W = y(L.SELF_SUPPORT.V), Z = H(() => {
    switch (W.value) {
      case L.JOINT_VENTURE.V:
      case L.LUMP_SUM_SYSTEM.V:
        return Le;
      case L.SELF_SUPPORT.V:
        return Ae;
      default:
        return null;
    }
  }), U = y(false), P = y();
  ne("dataId", P), K(() => P == null ? void 0 : P.value, (i) => {
    i && (U.value = true);
  });
  const B = y();
  function ee() {
    b.toQuery(), B.value = Math.random();
  }
  async function te() {
    const i = [], o = [], e = [], u = v.value[0].materialType;
    v.value.forEach(async (n) => {
      const w = await Pe(n.detailList);
      let p;
      u & N.MANUFACTURED.V ? p = await Re(n.detailList, { toSmallest: false, toNum: true }, { mete: ["mete", "productMete"] }) : p = await Ie(n.detailList, { toSmallest: false, toNum: true }, { mete: ["mete", "productMete"] }), n.detailList.map((t) => {
        let c;
        const a = t;
        switch (a.basicClass) {
          case g.STEEL_PLATE.V:
            c = xe({ classifyId: a.classifyId, name: a.classifyFullName, length: a.length, width: a.width, thickness: a.thickness }).then((_) => {
              a.theoryWeight = _, a.theoryTotalWeight = $(a.theoryWeight * (a.quantity || 0), F.value[g.STEEL_PLATE.V].weight.precision);
            });
            break;
          case g.SECTION_STEEL.V:
            c = ke({ length: a.length, unitWeight: a.unitWeight }).then((_) => {
              a.theoryWeight = _, a.theoryTotalWeight = $(a.theoryWeight * (a.quantity || 0), F.value[g.SECTION_STEEL.V].weight.precision), a.length && a.quantity ? a.totalLength = Oe({ length: a.length, quantity: a.quantity }) : a.totalLength = 0;
            });
            break;
          case g.STEEL_COIL.V:
            c = Ue({ classifyId: a.classifyId, name: a.classifyFullName, weight: a.weighingTotalWeight, width: a.width, thickness: a.thickness }).then((_) => {
              a.theoryLength = _, a.quantity = a.length;
            });
            break;
        }
        e.push(c);
      }), o.push(w), i.push(p);
    }), await Promise.all(o), await Promise.all(i), await Promise.all(e);
  }
  async function ae(i) {
    if (W.value = i, v.value = JSON.parse(JSON.stringify(M.value)), i === L.SELF_SUPPORT.V) {
      k = me.service({ lock: true, text: "正在加载数据并跳转，请稍后", fullscreen: true, background: "rgba(255, 255, 255, 0.5)" });
      try {
        v.value[0].materialType & N.MANUFACTURED.V || await se(), await te(), setTimeout(() => {
          k && k.close(), b.toAdd();
        }, 500);
      } catch (o) {
        console.log(o);
      }
    } else b.toAdd();
  }
  D.HOOK.handleRefresh = async (i, { data: o }) => {
    o.content.forEach(async (e) => {
      var n, w, p;
      const u = ve.getBits(g.ENUM, e.materialType, "L");
      e.typeText = u.join(" | "), e.projectAttribute = [], (n = e.projectInfos) == null || n.forEach((t) => {
        t.projectAttribute && e.projectAttribute.push(t.projectAttribute);
      }), e.branchCompanyId = (w = e.branchCompany) == null ? void 0 : w.id, e.projectAttribute = Array.from(new Set(e.projectAttribute)), e.inboundMete = e.inboundMete || 0, e.totalMete = e.totalMete || 0, e.projectNames = [], e.projectIds = [], (p = e.projectInfos) == null || p.forEach((t) => {
        e.projectNames.push(Me(t)), e.projectIds.push(t.id);
      }), e.projectNames = e.projectNames.join(",");
      for (const t in x.ENUM) e.level === x.ENUM[t].V && (e.levelStr = x.ENUM[t].L);
      e.detailList.forEach((t) => {
        var c;
        t.accountingUnit = void 0, t.projectAttribute = (c = t.project) == null ? void 0 : c.projectAttribute;
      }), e.purchaseCreationStates = e.purchaseCreationState;
    }), console.log();
  }, D.HOOK.afterSubmit = async () => {
    await j.dispatch("config/fetchSupplyUsedProject");
  };
  let k;
  const T = y(), M = y(), S = { STEEL: N.STEEL, OTHER_MATERIAL_TYPE: { L: "类型", K: "OTHER_MATERIAL_TYPE", V: g.MATERIAL.V | g.OTHER.V | g.GAS.V, T: "success" }, MANUF: N.MANUFACTURED };
  async function ie(i) {
    if ((i == null ? void 0 : i.length) > 10) {
      fe.error("至多选10条数据"), b.data.forEach((o) => {
        M.value.findIndex((e) => e.id === o.id) > -1 ? V.value.toggleRowSelection(o, true) : V.value.toggleRowSelection(o, false);
      });
      return;
    }
    M.value = i, T.value = i[0] || {};
  }
  async function se() {
    var o;
    const i = [];
    (o = M.value) == null || o.forEach((e) => {
      var u;
      (u = e.detailList) == null || u.forEach((n) => {
        i.includes(n.classifyId) || i.push(n.classifyId);
      });
    }), await je(i);
  }
  function oe(i) {
    var o, e, u;
    if (Ve(T.value)) {
      let n;
      ((o = T.value) == null ? void 0 : o.materialType) & S.STEEL.V && (n = S.STEEL.V), ((e = T.value) == null ? void 0 : e.materialType) & S.OTHER_MATERIAL_TYPE.V && (n = S.OTHER_MATERIAL_TYPE.V), ((u = T.value) == null ? void 0 : u.materialType) & S.MANUF.V && (n = S.MANUF.V);
      let w = true, p = true;
      n === S.MANUF.V && (Y(T.value.projectIds, i.projectIds) ? p = true : p = false);
      let t = true;
      return Y(T.value.branchCompanyId, i.branchCompanyId) ? t = true : t = false, w && i.materialType & n && p && t && i.purchaseCreationState !== I.COMPLETED.V;
    } else return i.purchaseCreationState !== I.COMPLETED.V;
  }
  return K(() => j.state.approval_list.isRefresh, (i) => {
    i && b.toQuery();
  }, { deep: true }), re(async () => {
    await j.dispatch("wms/fetchSteelDensityCfg");
  }), (i, o) => {
    const e = ye, u = ge, n = ce("common-table"), w = ue("permission"), p = be;
    return l(), R("div", Ke, [E(s(Fe), { selections: M.value, onHandleAdd: ae }, null, 8, ["selections"]), J((l(), r(n, { ref_key: "tableRef", ref: V, data: s(b).data, "data-format": G.value, "max-height": s(X), showEmptySymbol: false, class: "hidden-table-check-all", style: { width: "100%" }, onSelectionChange: ie }, { default: h(() => [E(e, { selectable: oe, align: "center", fixed: "left", type: "selection", width: "40" }), E(e, { align: "center", label: "序号", type: "index", width: "60" }), s(d).visible("createTime") ? (l(), r(e, { key: "createTime", align: "center", label: "申购创建日期", prop: "createTime", width: "150" })) : m("", true), s(d).visible("departmentName") ? (l(), r(e, { key: "departmentName", align: "center", label: "申购部门", prop: "departmentName", width: "90" })) : m("", true), s(d).visible("applicantName") ? (l(), r(e, { key: "applicantName", align: "center", label: "创建人", prop: "applicantName", width: "90" })) : m("", true), s(d).visible("projectAttribute") ? (l(), r(e, { key: "projectAttribute", align: "center", label: "经营方式", "min-width": "90", prop: "projectAttribute", "show-overflow-tooltip": "" }, { default: h(({ row: { sourceRow: t } }) => {
      var c;
      return [(c = t.projectAttribute) != null && c.length ? (l(), R("div", Je, [(l(true), R(pe, null, de(t.projectAttribute, (a) => {
        var _;
        return l(), r(u, { key: a, type: (_ = s(L).V[a]) == null ? void 0 : _.T, style: { "margin-left": "5px" } }, { default: h(() => [A(f(s(L).VL[a]), 1)]), _: 2 }, 1032, ["type"]);
      }), 128))])) : (l(), R("span", Ye, "-"))];
    }), _: 1 })) : m("", true), s(d).visible("serialNumber") ? (l(), r(e, { key: "serialNumber", align: "center", label: "申购编号", "min-width": "140", prop: "serialNumber", "show-overflow-tooltip": "" })) : m("", true), s(d).visible("projectNames") ? (l(), r(e, { key: "projectNames", label: "所属项目", "min-width": "170", prop: "projectNames", "show-overflow-tooltip": "" })) : m("", true), s(d).visible("typeText") ? (l(), r(e, { key: "typeText", align: "center", label: "材料分类", "min-width": "100", prop: "typeText", "show-overflow-tooltip": "" }, { default: h(({ row: t }) => [A(f(t.typeText || "-"), 1)]), _: 1 })) : m("", true), s(d).visible("branchCompanyId") ? (l(), r(e, { key: "branchCompanyId", align: "center", label: "申购单位", prop: "branchCompanyId", "show-overflow-tooltip": "", "min-width": "150" }, { default: h(({ row: { sourceRow: t } }) => {
      var c;
      return [A(f(((c = t.branchCompany) == null ? void 0 : c.name) || "-"), 1)];
    }), _: 1 })) : m("", true), E(e, { align: "center", label: "采购状态", "min-width": "120", prop: "purchaseCreationState" }, { default: h(({ row: t }) => [E(u, { type: s(I).V[t.purchaseCreationState].T, effect: "plain" }, { default: h(() => [A(f(s(I).VL[t.purchaseCreationState]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), s(d).visible("havePurchasedMete") ? (l(), r(e, { key: "havePurchasedMete", label: "已采购量/未采购量", prop: "havePurchasedMete", "show-overflow-tooltip": "", width: "150" }, { default: h(({ row: { sourceRow: t } }) => [A(f(t.havePurchasedMete || "-") + " / " + f(t.unPurchaseMete || "-") + f(t.meteUnit ? `(${t.meteUnit})` : ""), 1)]), _: 1 })) : m("", true), s(d).visible("inboundMete") ? (l(), r(e, { key: "inboundMete", label: "入库量", prop: "inboundMete", "show-overflow-tooltip": "", width: "150" }, { default: h(({ row: { sourceRow: t } }) => [A(f(t.inboundMete || "-") + f(t.meteUnit ? `(${t.meteUnit})` : ""), 1)]), _: 1 })) : m("", true), s(d).visible("dataStatus") ? (l(), r(e, { key: "reviewStatus", align: "center", label: "审批状态", "show-overflow-tooltip": "", width: "90" }, { default: h(({ row: t }) => [A(f(t.dataStatus), 1)]), _: 1 })) : m("", true), J((l(), r(e, { align: "center", label: "操作", width: "80" }, { default: h(({ row: { sourceRow: t } }) => [E(Ne, { data: { id: t.id }, "del-icon": q.value ? "el-icon-document-delete" : "el-icon-delete", "del-type": q.value ? "warning" : "danger", permission: s(O), showDel: false, showEdit: false, "show-detail": "" }, null, 8, ["data", "del-icon", "del-type", "permission"])]), _: 1 })), [[w, [...s(O).detail]]])]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[p, s(b).loading]]), E(s(Ce)), E(De, { "show-buttom": false }), (l(), r(he(Z.value), { isRequisition: true, requisitionList: v.value }, null, 8, ["requisitionList"])), (l(), r(qe, { key: B.value, visible: U.value, "onUpdate:visible": o[0] || (o[0] = (t) => U.value = t), "origin-form": { purchaseType: 2 }, onReset: ee }, null, 8, ["visible"]))]);
  };
} }, et = we($e, [["__scopeId", "data-v-252e6772"]]);
export {
  et as default
};
