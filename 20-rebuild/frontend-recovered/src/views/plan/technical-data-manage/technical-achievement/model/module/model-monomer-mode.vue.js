import { useStore as R } from "vuex";
import { ref as _ } from "vue";
import { resolveComponent as C } from "vue";
import { withDirectives as B } from "vue";
import { openBlock as r } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as o } from "vue";
import { createElementBlock as T } from "vue";
import { toDisplayString as k } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as v } from "vue";
import { createTextVNode as I } from "vue";
import { createElementVNode as U } from "vue";
import { ElNotification as M } from "element-plus";
import { ElMessageBox as G } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElTag as $ } from "element-plus";
import { vLoading as w } from "element-plus";
import { u as z, s as Q, t as q } from "../../../../../../modules/model-0ac957f7.js";
import { tr as F, a4 as i, t0 as g, i as H } from "../../../../../../shared/runtime.js";
import { _ as J } from "../../../../../../modules/SingleFileUploadBtn-17bec156.js";
const K = { key: 0 }, W = { key: 1 }, X = { style: { display: "flex", "justify-content": "center" } }, oe = { __name: "model-monomer-mode", props: { info: { type: Object, default: () => {
} } }, emits: ["translate-success"], setup(S, { expose: A, emit: D }) {
  const u = R(), b = D, p = S, y = _(null), N = _(false), d = _([]), O = _([["createTime", "parse-time"], ["updateTime", "parse-time"]]);
  async function V() {
    var s;
    M({ title: "上传成功", type: "success", message: "审批流已生成!请点击审批记录查看", duration: 2500 }), u.dispatch("approval_list/fetchApprovalNum"), u.dispatch("approval_list/fetchSubNum", g.PLAN_MODEL_DOCUMENT_MANAGE.V), u.dispatch("approval_list/fetchApprovalNum", g.PLAN_MODEL_DOCUMENT_MANAGE.V), u.dispatch("approval_list/fetchRejNum", g.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.V), await c(), ((s = d.value) == null ? void 0 : s.some((t) => (t == null ? void 0 : t.translateStatus) === i.PROCESSING.V || (t == null ? void 0 : t.translateStatus) === i.UPLOAD_PROCESSING.V)) ? (clearInterval(y.value), y.value = setInterval(() => {
      var f;
      c(), ((f = d.value) == null ? void 0 : f.every((n) => (n == null ? void 0 : n.translateStatus) !== i.PROCESSING.V && (n == null ? void 0 : n.translateStatus) !== i.UPLOAD_PROCESSING.V)) && (clearInterval(y.value), c(), b("translate-success"));
    }, 1e3 * 60)) : b("translate-success");
  }
  async function c() {
    try {
      N.value = true;
      const a = await Q({ monomerId: p.info.id }) || {};
      d.value = [{ ...a, projectName: p.info.projectName, monomerName: p.info.name, edition: p.info.edition, hasModelImport: H(a == null ? void 0 : a.id) }];
    } catch (a) {
      console.log("单体模型信息", a);
    } finally {
      N.value = false;
    }
  }
  async function L(a) {
    G.confirm(`是否确认删除 “${a.monomer.name}” 单体下的模型`, "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await q({ monomerId: a.monomer.id }), M({ title: "删除模型成功", type: "success" }), c();
      } catch (s) {
        console.log("删除模型失败", s);
      }
    });
  }
  return A({ fetchData: c }), (a, s) => {
    const t = j, f = $, n = C("common-button"), x = C("common-table"), P = w;
    return B((r(), h(x, { data: d.value, "data-format": O.value, style: { width: "100%" } }, { default: l(() => [o(t, { align: "center", label: "序号", type: "index", width: "60" }), o(t, { "show-overflow-tooltip": true, align: "center", label: "单体", prop: "monomerName" }), o(t, { "show-overflow-tooltip": true, align: "center", label: "版本号", prop: "edition" }, { default: l(({ row: { sourceRow: e } }) => [e != null && e.edition ? (r(), T("span", K, k(m(F).VL[e == null ? void 0 : e.edition]), 1)) : v("", true)]), _: 1 }), o(t, { "show-overflow-tooltip": true, align: "center", label: "模型状态", prop: "translateStatus" }, { default: l(({ row: { sourceRow: e } }) => [e != null && e.translateStatus ? (r(), h(f, { key: 0, type: m(i).V[e.translateStatus].T, effect: "plain" }, { default: l(() => [I(k(m(i).VL[e.translateStatus]), 1)]), _: 2 }, 1032, ["type"])) : (r(), T("span", W, "-"))]), _: 1 }), o(t, { key: "createUserName", align: "center", label: "创建者", prop: "createUserName", "show-overflow-tooltip": "" }), o(t, { key: "createTime", align: "center", label: "创建时间", prop: "createTime", "show-overflow-tooltip": "" }), o(t, { key: "updateTime", align: "center", label: "编辑时间", prop: "updateTime", "show-overflow-tooltip": "" }), o(t, { key: "successQuantity", align: "center", label: "转换成功次数", prop: "successQuantity", "show-overflow-tooltip": "" }), o(t, { align: "center", label: "操作", width: "170" }, { default: l(({ row: e }) => {
      var E;
      return [U("div", X, [o(m(J), { accept: ".ifc", "btn-name": `${e != null && e.hasModelImport ? "替换模型" : "导入模型"}`, data: { monomerId: (E = S.info) == null ? void 0 : E.id }, fileClassify: void 0, "upload-fun": m(z), "btn-size": "default", "btn-type": "warning", "success-msg": "模型导入成功", onSuccess: V }, null, 8, ["btn-name", "data", "upload-fun"]), e != null && e.hasModelImport ? (r(), h(n, { key: 0, size: "default", style: { "margin-left": "5px" }, type: "danger", onClick: (Y) => L(e) }, { default: l(() => s[0] || (s[0] = [I(" 删除 ")])), _: 2, __: [0] }, 1032, ["onClick"])) : v("", true)])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format"])), [[P, N.value]]);
  };
} };
export {
  oe as default
};
