import { ref as B } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { withDirectives as K } from "vue";
import { unref as n } from "vue";
import { createVNode as s } from "vue";
import { createElementVNode as W } from "vue";
import { createElementBlock as L } from "vue";
import { Fragment as D } from "vue";
import { renderList as X } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as Y } from "vue";
import { withModifiers as P } from "vue";
import { createCommentVNode as N } from "vue";
import { isRef as Z } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { ElImage as te } from "element-plus";
import { ElTag as ae } from "element-plus";
import { ElPagination as oe } from "element-plus";
import { vLoading as ne } from "element-plus";
import { m as ie, n as I } from "../../../../../../modules/inspection-config-a69d9e2f.js";
import { _ as se, u as le, J as re, o as ce, mQ as b, G as j } from "../../../../../../shared/runtime.js";
const pe = { class: "imgs-box" }, de = ["src"], me = { __name: "audit-detail", props: { visible: { type: Boolean, default: false }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(v, { emit: M }) {
  const w = B(false), z = B(), x = B([]), k = M, E = v, { visible: C, handleClose: S } = le({ emit: k, props: E, field: "visible" }), { handleSizeChange: R, handleCurrentChange: F, total: O, setTotalPage: $, queryPage: V } = re({ fetchHook: u });
  Q(() => E.visible, (o) => {
    o && u();
  });
  const { maxHeight: q } = ce({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, z);
  async function u() {
    var o;
    try {
      w.value = true;
      const { content: t = [], totalElements: i } = await ie({ ...V });
      $(i), x.value = t || [], (o = x.value) == null || o.forEach((r) => {
        var g, p, f, _, h, y;
        r.pointStr = (p = (g = r.pointList) == null ? void 0 : g.map((e) => e.name)) == null ? void 0 : p.join("、"), r.removeStr = (_ = (f = r.removePointList) == null ? void 0 : f.map((e) => e.name)) == null ? void 0 : _.join("、"), r.imgs = (y = (h = r.applyAnnexDTOList) == null ? void 0 : h.filter((e) => {
          var a, d;
          return ((d = (a = e.name) == null ? void 0 : a.split(".")) == null ? void 0 : d.slice(-1)[0]) !== "mp4";
        })) == null ? void 0 : y.map((e) => e.imageUrl);
      });
    } catch (t) {
      console.log(t, "获取审核列表详情失败");
    } finally {
      w.value = false;
    }
  }
  async function G(o) {
    await U.confirm("确认审核通过当前数据删除巡检点位的操作?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(async () => {
      const t = { auditStatus: b.PASS.V, recordId: o == null ? void 0 : o.id };
      await I(t), H.success("审核通过"), u(), k("success"), S();
    }).catch(() => {
    });
  }
  async function J(o) {
    await U.confirm("确认驳回当前数据删除巡检点位的操作?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "danger" }).then(async () => {
      const t = { auditStatus: b.FAIL.V, recordId: o == null ? void 0 : o.id };
      await I(t), H.warning("驳回成功"), u(), k("success"), S();
    }).catch(() => {
    });
  }
  return (o, t) => {
    const i = ee, r = te, g = ae, p = A("common-button"), f = A("common-table"), _ = oe, h = A("common-drawer"), y = ne;
    return c(), m(h, { ref_key: "drawerRef", ref: z, title: "巡检点审核", modelValue: n(C), "onUpdate:modelValue": t[0] || (t[0] = (e) => Z(C) ? C.value = e : null), "close-on-click-modal": false, direction: "rtl", "before-close": n(S), size: "70%" }, { titleRight: l(() => t[1] || (t[1] = [])), content: l(() => [K((c(), m(f, { data: x.value, "max-height": n(q), "show-empty-symbol": false, "return-source-data": "", style: { width: "100%" } }, { default: l(() => [s(i, { label: "序号", type: "index", align: "center", width: "60" }), s(i, { prop: "createUserName", "show-overflow-tooltip": "", label: "创建人", "min-width": "90px", align: "center" }), s(i, { prop: "canAuditUserName", "show-overflow-tooltip": "", label: "可审核人", "min-width": "90px", align: "center" }), s(i, { prop: "pointStr", "show-overflow-tooltip": "", label: "巡检点位", "min-width": "120px", align: "center" }), s(i, { prop: "removeStr", "show-overflow-tooltip": "", label: "删除巡检点位", align: "center" }), s(i, { prop: "attachment", "show-overflow-tooltip": "", label: "附件", align: "center", "min-width": "120" }, { default: l(({ row: e }) => [W("div", pe, [(c(true), L(D, null, X(e.applyAnnexDTOList, (a) => {
      var d;
      return c(), L(D, { key: a.id }, [((d = a.name) == null ? void 0 : d.split(".").slice(-1)[0]) !== "mp4" ? (c(), m(r, { key: 0, "preview-src-list": e.imgs, "initial-index": 1, src: a.imageUrl, "preview-teleported": "" }, null, 8, ["preview-src-list", "src"])) : (c(), L("video", { controls: true, ref_for: true, ref: `media_${a.id}`, width: "100", height: "70", autoplay: false, loop: false, muted: true, style: { display: "block", "margin-bottom": "8px" }, key: a.imageUrl, src: a.imageUrl }, null, 8, de))], 64);
    }), 128))])]), _: 1 }), s(i, { prop: "remark", "show-overflow-tooltip": "", label: "备注", align: "center" }), s(i, { prop: "auditState", "show-overflow-tooltip": "", label: "审核状态", align: "center" }, { default: l(({ row: e }) => {
      var a;
      return [s(g, { type: (a = n(b).V[e == null ? void 0 : e.auditState]) == null ? void 0 : a.T }, { default: l(() => [T(Y(n(b).VL[e == null ? void 0 : e.auditState]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), s(i, { "show-overflow-tooltip": "", label: "操作", align: "center", width: "160px" }, { default: l(({ row: e }) => [n(j)(v.permission.passAudit) ? (c(), m(p, { key: 0, type: "warning", size: "default", onClick: P((a) => G(e), ["stop"]) }, { default: l(() => t[2] || (t[2] = [T(" 通过 ")])), _: 2, __: [2] }, 1032, ["onClick"])) : N("", true), n(j)(v.permission.rejectAudit) ? (c(), m(p, { key: 1, type: "danger", size: "default", onClick: P((a) => J(e), ["stop"]) }, { default: l(() => t[3] || (t[3] = [T(" 驳回 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : N("", true)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[y, w.value]]), s(_, { total: n(O), "current-page": n(V).pageNumber, "page-size": n(V).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(R), onCurrentChange: n(F) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, _e = se(me, [["__scopeId", "data-v-2a2817bc"]]);
export {
  _e as default
};
